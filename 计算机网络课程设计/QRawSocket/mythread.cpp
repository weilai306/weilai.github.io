#include "mythread.h"
#include <QDebug>
#include <QMessageBox>
#define SIO_RCVALL _WSAIOW(IOC_VENDOR,1)
MyThread::MyThread(const char * ip,int port):QThread()
{
    WSADATA wsd;
    if (WSAStartup(MAKEWORD(2, 2), &wsd) != 0)
    {
        qDebug()<<"error 16";
    }

    sock = socket(AF_INET, SOCK_RAW, IPPROTO_IP);
    if (sock == INVALID_SOCKET)
    {
        closesocket(sock);
        WSACleanup();
        qDebug()<<"error 24";
        int res=QMessageBox::information(NULL, "ERROR", "Please check the administrator permissions");
        if(res==QMessageBox::Ok)
        {
            quit();
        }
    }
    BOOL flag = true;
    if (setsockopt(sock, IPPROTO_IP, 2, (char*)&flag, sizeof(flag)) == SOCKET_ERROR)
    {
        closesocket(sock);
        WSACleanup();
        qDebug()<<"error 31";
    }

    SOCKADDR_IN addr;
    addr.sin_family = AF_INET;
    addr.sin_port = htons(port);
    addr.sin_addr.S_un.S_addr = inet_addr(ip);

    if (bind(sock, (struct sockaddr*)&addr, sizeof(addr)) == SOCKET_ERROR) {
        qDebug()<<"error 52";
        closesocket(sock);
        WSACleanup();
    }

    DWORD dwBufferInLen = 1;
    //将网卡设置为混听模式，就是接收所有数据
    if (ioctlsocket(sock, SIO_RCVALL, &dwBufferInLen) == SOCKET_ERROR) {
        qDebug()<<"error 62";
        closesocket(sock);
        WSACleanup();
    }
}

void MyThread::setIpPort(const char *ip, int port)
{
    WSADATA wsd;
    if (WSAStartup(MAKEWORD(2, 2), &wsd) != 0)
    {
        qDebug()<<"error 16";
    }

    sock = socket(AF_INET, SOCK_RAW, IPPROTO_IP);
    if (sock == INVALID_SOCKET)
    {
        closesocket(sock);
        WSACleanup();
        qDebug()<<"error 24";
    }
    BOOL flag = true;
    if (setsockopt(sock, IPPROTO_IP, 2, (char*)&flag, sizeof(flag)) == SOCKET_ERROR)
    {
        closesocket(sock);
        WSACleanup();
        qDebug()<<"error 31";
    }

    SOCKADDR_IN addr;
    addr.sin_family = AF_INET;
    addr.sin_port = htons(port);
    addr.sin_addr.S_un.S_addr = inet_addr(ip);

    if (bind(sock, (struct sockaddr*)&addr, sizeof(addr)) == SOCKET_ERROR) {
        qDebug()<<"error 52";
        closesocket(sock);
        WSACleanup();
    }

    DWORD dwBufferInLen = 1;
    //将网卡设置为混听模式，就是接收所有数据
    if (ioctlsocket(sock, SIO_RCVALL, &dwBufferInLen) == SOCKET_ERROR) {
        qDebug()<<"error 62";
        closesocket(sock);
        WSACleanup();
    }
}
void MyThread::setSock(SOCKET socket)
{
    this->sock=socket;
}

void MyThread::setLabel(QLabel* l)
{
    this->status=l;
}

void MyThread::setTableWidget(QTableWidget *widget)
{
    this->widget=widget;
}

void MyThread::setFilter(Filter *f)
{
    if(f!=NULL)
    {
        this->filter=new Filter();
        filter->fip=f->fip;
        filter->fport=f->fport;
        filter->passNull=f->passNull;
    }
    else
    {
        filter=NULL;
    }
}

void MyThread::deleteFilter()
{
    if(filter)
    {
        delete filter;
    }
    filter=NULL;
}
void MyThread::run()
{
    IP* ip;
    TCP* tcp;
    int bytesRecv;
    char buffer[65535];
    struct sockaddr_in from;
    QTableWidgetItem* item;
    int fromSize = sizeof(from);
    while (true) {
        memset(buffer, 0, 65535);
        if(this->threadExit==true)
        {
            break;
        }
        bytesRecv = recvfrom(sock, buffer, 65535, 0, (struct sockaddr*)&from, &fromSize);
        if (bytesRecv == SOCKET_ERROR) {
            //cout << "error:" << WSAGetLastError() << endl;
            closesocket(sock);
            WSACleanup();
        }

        ip = (struct IP*)buffer;

        if (ip->protocal == 6) {//过滤其他协议，只留下TCP协议
            tcp = (struct TCP*)(buffer + (4 * (ip->headLen & 0x0f)));//得到TCP头
            char* start = (char*)tcp + 4 * ((tcp->headLen & 0xf0) >> 4);//计算数据头指针，从何处开始数据
            int dataSize = bytesRecv - (start - buffer);//计算数据长度
            if (bytesRecv > 0)
            {             
                if(filter!=NULL)
                {
                    if(filter->fip!=QString("0.0.0.0")
                            &&filter->fip!=QString(inet_ntoa(*(in_addr*)&ip->sourceAddr))
                            &&filter->fip!=QString(inet_ntoa(*(in_addr*)&ip->destinAddr)))
                    {
                        continue;
                    }
                    if(filter->fport!=QString("0")
                            &&filter->fport!=QString::number(ntohs(tcp->sourcePort))
                            &&filter->fport!=QString::number(ntohs(tcp->destinPort)))
                    {
                            continue;
                    }
                    if(filter->passNull==true&&dataSize==0)
                    {
                        continue;
                    }
                }
                if(filter==NULL&&dataSize==0)
                {
                    continue;
                }
                QStringList slist;
                slist.append(QString(inet_ntoa(*(in_addr*)&ip->sourceAddr)));
                slist.append(QString::number(ntohs(tcp->sourcePort)));
                slist.append(QString(inet_ntoa(*(in_addr*)&ip->destinAddr)));
                slist.append(QString::number(ntohs(tcp->destinPort)));
                slist.append(QString::number(bytesRecv));
                memcpy(buffer, start, dataSize);
                QString datastr="";
                for (int i = 0; i < dataSize; i++)
                {
                    if (buffer[i] >= 32) {
                        //printf("%c", (unsigned char)buffer[i]);
                        datastr.append((unsigned char)buffer[i]);
                    }
                    else {
                        // printf(".");
                        datastr.append(".");
                    }
                }
                slist.append(datastr);               
                if(widget->rowCount()<300)
                {
                    widget->setRowCount(widget->rowCount()+1);
                    for(int i=0;i<6;i++)
                    {
                        item=new QTableWidgetItem(slist.at(i));
                        widget->setItem(widget->rowCount()-1,i,item);
                    }
                }
            }          
        }
    }
}

MyThread::MyThread():QThread()
{

}
