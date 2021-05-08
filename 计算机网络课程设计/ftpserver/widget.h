#ifndef WIDGET_H
#define WIDGET_H

#include <QWidget>
#include <thread>
#include <QTextEdit>
#include <winsock2.h>
//using namespace std;
QT_BEGIN_NAMESPACE
namespace Ui { class Widget; }
QT_END_NAMESPACE

class Widget : public QWidget
{
    Q_OBJECT
    friend std::thread;
public:
    Widget(QWidget *parent = nullptr);
    ~Widget();
    static void listen(SOCKET s);
    static void recvI(SOCKET s,QString info);
    static QTextEdit* edit;
private:
    Ui::Widget *ui;
    static QString filepath;//文件名
    void ini();
};

#endif // WIDGET_H
