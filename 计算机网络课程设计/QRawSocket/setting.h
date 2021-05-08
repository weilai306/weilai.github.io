#ifndef SETTING_H
#define SETTING_H

#include <QDialog>
#include <QString>
namespace Ui {
class Setting;
}

class Setting : public QDialog
{
    Q_OBJECT

public:
    friend class Widget;
    explicit Setting(QWidget *parent = nullptr);
    ~Setting();

signals:
    void mysignal(bool a,bool b,QString c,QString d);
private slots:
    void on_buttonClear_clicked();

    void on_buttonConfirm_clicked();

private:
    Ui::Setting *ui;
};

#endif // SETTING_H
