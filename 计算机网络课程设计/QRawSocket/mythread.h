#ifndef MYTHREAD_H
#define MYTHREAD_H
#include <WinSock2.h>
#include <QThread>
#include <QLabel>
#include <QTableWidget>
#include "headers.h"

struct Filter{
    bool passNull=true;
    QString fip;
    QString fport;
};

class MyThread:public QThread
{
public:
    void run();
    MyThread();
    MyThread(const char * ip,int port);
    void setIpPort(const char * ip,int port);
    void setSock(SOCKET socket);
    void setLabel(QLabel* l);
    void setTableWidget(QTableWidget* widget);
    bool threadExit=false;
    void setFilter(Filter* f);
    void deleteFilter();
private:
    SOCKET sock;
    QLabel* status;

    QTableWidget* widget;
    int maxContain;//最大信息缓存
    Filter* filter=NULL;
signals:
    void isDone();
};

#endif // MYTHREAD_H
