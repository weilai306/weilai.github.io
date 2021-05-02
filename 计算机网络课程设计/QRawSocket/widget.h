#ifndef WIDGET_H
#define WIDGET_H

#include <QWidget>
#include "mythread.h"
#include <setting.h>
QT_BEGIN_NAMESPACE
namespace Ui { class Widget; }
QT_END_NAMESPACE


class Widget : public QWidget
{
    Q_OBJECT

public:
    Widget(QWidget *parent = nullptr);
    ~Widget();

private slots:
    void on_buttonbind_clicked();

    void on_tableWidget_cellDoubleClicked(int row, int column);

    void on_buttonClose_clicked();

    void on_buttonClear_clicked();

    void on_buttonSetting_clicked();

private:
    Ui::Widget *ui;
    MyThread* mth=NULL;
    Filter* filter;
    Setting* s;
};
#endif // WIDGET_H
