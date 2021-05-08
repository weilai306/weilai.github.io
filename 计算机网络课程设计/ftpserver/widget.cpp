#include "widget.h"
#include "ui_widget.h"
#include "QFileInfo"
#include <QDebug>
#include <QMessageBox>
QTextEdit* Widget::edit=NULL;
QString Widget::filepath=QString("D:/ftpfile/");
Widget::Widget(QWidget *parent)
    : QWidget(parent)
    , ui(new Ui::Widget)
{
    ui->setupUi(this);
    edit=ui->textEdit;
    setWindowTitle("JLU Server Port:5518");
    ini();
}
void Widget::ini()
{
    WSADATA wsaData;
    WORD sockVersion = MAKEWORD(2, 2);
    if (::WSAStartup(sockVersion, &wsaData) != 0)
    {
       qDebug()<<"17";
    }

    SOCKET sListen = ::socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    if (sListen == INVALID_SOCKET)
    {
        qDebug()<<"22";
    }

    sockaddr_in sin;
    sin.sin_family = AF_INET;
    sin.sin_port = htons(5518);  //1024 ~ 49151：普通用户注册的端口号
    sin.sin_addr.S_un.S_addr = INADDR_ANY;

    // 绑定这个套节字到一个本地地址
    if (::bind(sListen, (LPSOCKADDR)&sin, sizeof(sin)) == SOCKET_ERROR)
    {
        qDebug()<<"33";
        //printf("Failed bind() \n");
    }

    // 进入监听模式
    //2指的是，监听队列中允许保持的尚未处理的最大连接数

    if (::listen(sListen, 2) == SOCKET_ERROR)
    {
        qDebug()<<"42";
        //printf("Failed listen() \n");
    }

    std::thread* tlisten;
    tlisten=new std::thread(listen,sListen);
}
void Widget::listen(SOCKET sListen)
{
    SOCKET sClient = 0;
    sockaddr_in remoteAddr;
    int nAddrLen = sizeof(remoteAddr);
    std::thread* trecv;
    while (1)
    {
        sClient = ::accept(sListen, (SOCKADDR*)&remoteAddr, &nAddrLen);
        if (sClient == INVALID_SOCKET)
        {
            printf("Failed accept()");
        }
        if(inet_ntoa(remoteAddr.sin_addr)!="0.0.0.0")
        {
            edit->append(QString("RECV a New Connect：%1:%2").arg(inet_ntoa(remoteAddr.sin_addr)).arg(ntohs(remoteAddr.sin_port)));
            QString info=QString("%1:%2").arg(inet_ntoa(remoteAddr.sin_addr)).arg(ntohs(remoteAddr.sin_port));
            trecv = new std::thread(recvI, sClient,info);
        }

    }
}

void Widget::recvI(SOCKET socket,QString remoteInfo)
{
    char buff[65535];
    while (1)
    {
        // 从客户端接收数据
        int nRecv = ::recv(socket, buff, 65534, 0);

        if (nRecv > 0)
        {
            buff[nRecv] = '\0';
            //printf(" 接收到数据：%s\n", buff);            
            break;
        }
    }
    QFile file;
    QString filename(buff);
    file.setFileName(filepath+filename);
    bool ok=file.open(QFile::ReadOnly);
    if(ok==false)
    {
        qDebug()<<"file not exist";
        QString str="FILENOTFOUND";
        //closesocket(socket);
        edit->append("REQUEST FILE NOT FOUNE: CONNECT CLOSE");
        strcpy(buff,str.toStdString().c_str());
        ::send(socket,buff,sizeof (buff),0);
        return;
    }
    QFileInfo info(file);
    long long filesize=info.size();
    QString str=filename+"&&"+QString::number(filesize)+"&&";
    strcpy(buff,str.toStdString().c_str());
    ::send(socket,buff,sizeof (buff),0);

   Sleep(100);
   int len;
   do
   {
       len=file.read(buff,sizeof (buff));
       ::send(socket,buff,len,0);
       qDebug()<<len;
   }while(len>0);

   file.close();
   edit->append("SEND COMPLETE FILE NAME:"+filename+" To "+remoteInfo);
};


Widget::~Widget()
{
    delete ui;
}



