#ifndef MYTHREAD_H
#define MYTHREAD_H

#include <QThread>
#include <QFile>
#include <thread>
#include <QTimer>
class MyThread:public QThread
{
    Q_OBJECT
public:
    void run();
    void setPtr(int);
   // void setTcpServer(QTcpServer* tcpserver);
private:
    int ptr;
    qlonglong filesize;
    qlonglong sendsize;
    QTcpSocket* tcpsocket;
    QFile* file;
    QTimer* timer;
signals:
    void sendMessage(QString);

private slots:
    void writeonce();
};

#endif // MYTHREAD_H
