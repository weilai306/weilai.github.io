#include "client.h"
#include "ui_client.h"
#include "QMessageBox"
#include "QInputDialog"
#include <QFileDialog>
QString Client::filepath=QString("D:/ftprecv/");
Client::Client(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Client)
{
    ui->setupUi(this);
    ui->lineEditIp->setText("127.0.0.1");
    ui->lineEditPort->setText("5518");
    setWindowTitle("JLU Client");
    ui->editFilePath->setText("D:/ftprecv/");
    WSADATA wsaData;
    WORD sockVersion = MAKEWORD(2, 2);
    if (::WSAStartup(sockVersion, &wsaData) != 0)
    {
        qDebug()<<"17";
    }

    connect(this,&Client::closeButton,this,&Client::recvCloseButton);
    ui->buttonClose->setEnabled(false);
    ui->buttonRequst->setEnabled(false);
}

Client::~Client()
{
    delete ui;
}

void Client::on_pushButton_clicked()
{
    s = ::socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    if (s == INVALID_SOCKET)
    {
        qDebug()<<"26";
    }
    //获取服务器的Ip和端口
    QString ip=ui->lineEditIp->text();
    int port=ui->lineEditPort->text().toInt();

    sockaddr_in servAddr;
    servAddr.sin_family = AF_INET;
    servAddr.sin_addr.S_un.S_addr = inet_addr(ip.toStdString().c_str());
    servAddr.sin_port = htons(port);
    if (::connect(s, (sockaddr*)&servAddr, sizeof(servAddr)) == -1)
    {
        ui->textEdit->append("CONNECT FAILED "+QString::number(WSAGetLastError()));
        qDebug()<< WSAGetLastError();
        return;
    }

    ui->textEdit->append("SUCCESS CONNECT");
    ui->buttonClose->setEnabled(true);
    ui->buttonRequst->setEnabled(true);
}

void Client::recvCloseButton()
{
    ui->buttonClose->setEnabled(false);
    ui->buttonRequst->setEnabled(false);
}


void Client::on_buttonRequst_clicked()
{
    QString filename=QInputDialog::getText(this,"输入文件名","请输入文件名");
    this->filename=filename;
    char sendText[65535];
    const char* tmp=(filename).toStdString().c_str();
    strcpy(sendText,tmp);
    ::send(s,sendText,strlen(sendText),0);
    std::thread* trecv=new std::thread(recvI,s,this);
}

void Client::recvI(SOCKET socket,Client * c)
{
    char buff[65536];
    while (1)
    {
        // 从客户端接收数据
        int nRecv = ::recv(socket, buff, 65535, 0);

        if (nRecv > 0)
        {
            buff[nRecv] = '\0';
            break;
        }
    }
    QString str(buff);
    if(str=="FILENOTFOUND")
    {
        emit(c->Recvoutput("FILE NOT FOUND"));
        emit(c->closeButton());
        closesocket(socket);
        return;
    }
    QString filename=str.section("&&",0,0);
    long long int filesize=str.section("&&",1,1).toLongLong();
    connect(c,&Client::changeProbar,c,&Client::getProbar);
    QFile file;
    file.setFileName(filepath+filename);
    bool ok=file.open(QFile::WriteOnly);
    if(ok==false)
    {
        qDebug()<<"File open error 100";
    }

    int nRecv;
    long long int recvsize=0;
    do
    {
        nRecv = ::recv(socket, buff, 65535, 0);
        buff[nRecv] = '\0';
        recvsize+=nRecv;
        emit(c->changeProbar(recvsize*100.0/filesize));
        file.write(buff,nRecv);
        qDebug()<<nRecv;
    }while(recvsize!=filesize);

    file.close();
    closesocket(socket);
    QString sendStr=QString("Recv File Success:")+(filename);
    emit(c->Recvoutput(sendStr));
}

void Client::getProbar(int s)
{
    ui->progressBar->setValue(s);
}

void Client::Recvoutput(QString s)
{
    ui->textEdit->append(s);
}

void Client::on_buttonClose_clicked()
{
    closesocket(s);
    ui->buttonClose->setEnabled(false);
    ui->buttonRequst->setEnabled(false);
    ui->textEdit->append("CLOSE CONNECT");
}

void Client::on_toolButton_clicked()
{
    QString srcDirPath = QFileDialog::getExistingDirectory(this, "choose src Directory","/");
    qDebug()<<srcDirPath;
    srcDirPath+='/';
    ui->editFilePath->setText(srcDirPath);
    filepath=srcDirPath;
}
