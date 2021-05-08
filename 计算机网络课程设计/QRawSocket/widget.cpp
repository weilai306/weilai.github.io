#include "widget.h"
#include "ui_widget.h"
#include <QDebug>
Widget::Widget(QWidget *parent)
    : QWidget(parent)
    , ui(new Ui::Widget)
{
    ui->setupUi(this);
    ui->labelStatus->setText("服务未启动");
    ui->buttonClear->setEnabled(false);
    ui->buttonClose->setEnabled(false);
    setWindowTitle("JLU 计算机网络课程设计Title3 by-551802");
    filter= NULL;
    s=new Setting();
}

Widget::~Widget()
{
    delete ui;
}

void Widget::on_buttonbind_clicked()
{
    const char* ip;
    ip=ui->lineEditIp->text().toStdString().c_str();
    int port=ui->lineEditPort->text().toInt();

    mth=new MyThread(ip,port);
    mth->setFilter(filter);

    mth->setTableWidget(ui->tableWidget);
    mth->setLabel(ui->labelStatus);
    mth->start();
    ui->lineEditIp->setEnabled(false);
    ui->lineEditPort->setEnabled(false);
    ui->buttonbind->setEnabled(false);
    ui->buttonSetting->setEnabled(false);
    ui->buttonClear->setEnabled(true);
    ui->buttonClose->setEnabled(true);
    ui->labelStatus->setText("服务已启动");
}

void Widget::on_tableWidget_cellDoubleClicked(int row, int column)
{
    ui->textEditData->setText(ui->tableWidget->item(row,column)->text().toUtf8());
}

void Widget::on_buttonClose_clicked()
{
    mth->threadExit=true;
    while(1)
    {
        if(mth->isFinished())
        {
            mth->quit();
            break;
        }
    }
    mth=NULL;
    ui->lineEditIp->setEnabled(true);
    ui->lineEditPort->setEnabled(true);
    ui->buttonbind->setEnabled(true);
    ui->buttonSetting->setEnabled(true);
    ui->buttonClear->setEnabled(false);
    ui->buttonClose->setEnabled(false);
    ui->textEditData->clear();
    ui->tableWidget->setRowCount(1);
    ui->labelStatus->setText("服务未启动");
}

void Widget::on_buttonClear_clicked()
{
    ui->tableWidget->setRowCount(1);
    ui->textEditData->clear();
}

void Widget::on_buttonSetting_clicked()
{
    s->show();
    connect(s,&Setting::mysignal,this,
            [=](bool a,bool b,QString c,QString d)
    {
        if(a==false)
        {
            filter=NULL;
        }
        else
        {
            filter= new Filter;
            filter->passNull=b;
            filter->fip=c;
            filter->fport=d;
        }
        s->hide();
    });

}
