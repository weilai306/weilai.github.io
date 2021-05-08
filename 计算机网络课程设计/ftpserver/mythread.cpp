#include "mythread.h"
#include <QFileInfo>
#include <QHostAddress>
#include <QDebug>
#include<QTimer>
void MyThread::run()
{
    tcpsocket=new QTcpSocket();
    tcpsocket->setSocketDescriptor(ptr);
    //获取对方的IP和端口
    QString ip=tcpsocket->peerAddress().toString();
    ip=ip.section(':',3,3);
    quint16 port =tcpsocket->peerPort();
    QString m=QString("[%1:%2] 成功连接\n").arg(ip).arg(QString::number(port));
    emit(sendMessage(m));

    QString str;
    while(1)
    {
       bool a= tcpsocket->waitForReadyRead(30000);
       if(a==false)
       {
           exit(0);
       }
       str=tcpsocket->readAll();
       if(str!="")
           break;
    }

    QString filename=str;
    QString defilepath="D:/ftpfile/";
    QString filepath=defilepath+filename;
    ip=tcpsocket->peerAddress().toString();
    ip=ip.section(':',3,3);
    port =tcpsocket->peerPort();
    file=new QFile;
    file->setFileName(filepath);
    bool isOk=file->open(QIODevice::ReadOnly);
    if(isOk==false)
    {
        qDebug()<<"fileopen Thread error 53";
        tcpsocket->write(QString("FileNotFound").toUtf8());
        tcpsocket->waitForBytesWritten();
    }
    else
    {
        QFileInfo info(*file);
        QByteArray sendstr=(QString("%1&&%2&&").arg(info.fileName()).arg(info.size())).toUtf8();
        qint64 len=tcpsocket->write(sendstr);
        qDebug()<<"len="+QString::number(len);
        bool a=tcpsocket->waitForBytesWritten();
        if(a==false)
        {
            exit(-1);
        }
        msleep(2000);
        QString strMess("Start:"+QString("[%1:%2] ").arg(ip).arg(QString::number(port))+QString("file:%1 size:%2\n").arg(info.fileName()).arg(info.size()));
        emit(QString(strMess));
        sendsize=0;
        if(len>0)
        {
            qint64 len=0;
            char buf[4096*40]={0};
            do
            {
                len= file->read(buf,sizeof(buf));
                len= tcpsocket->write(buf,len);
                sendsize+=len;
                bool a=tcpsocket->waitForBytesWritten();
                if(a==false)
                {
                    exit(-1);
                }
                //qDebug()<<QString::number(sendsize);
            }while(len>0);
            if(sendsize==info.size())
            {
                qDebug()<<"success";
            }
        }
        else
        {
            qDebug()<<"writehead error 61";
        }
    }
}

void MyThread::setPtr(int ptr)
{
    this->ptr=ptr;
}

void MyThread::writeonce()
{
    qint64 len=0;
    static char buf[4096]={0};
    len= file->read(buf,sizeof(buf));
    len= tcpsocket->write(buf,len);
    sendsize+=len;
    tcpsocket->waitForBytesWritten();
    qDebug()<<QString::number(sendsize);
}



