#ifndef CLIENT_H
#define CLIENT_H
#include <QWidget>
#include <QFile>
#include <winsock2.h>
#include <QTextEdit>
#include <QDebug>
#include <thread>
namespace Ui {
class Client;
}

class Client : public QWidget
{
    Q_OBJECT
    friend class thread;
public:
    explicit Client(QWidget *parent = nullptr);
    ~Client();
    static void recvI(SOCKET socket,Client * c);
signals:
    void changeProbar(int);
    void closeButton();
    void fileRecvSuccess(QString);
private slots:
    void getProbar(int);
    void Recvoutput(QString);
    void on_pushButton_clicked();
    void recvCloseButton();
    void on_buttonRequst_clicked();

    void on_buttonClose_clicked();

    void on_toolButton_clicked();

private:
    Ui::Client *ui;
    static QString filepath;
    QString filename;
    SOCKET s;

};

#endif // CLIENT_H
