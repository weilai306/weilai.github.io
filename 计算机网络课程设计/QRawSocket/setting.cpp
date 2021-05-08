#include "setting.h"
#include "ui_setting.h"

Setting::Setting(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Setting)
{
    ui->setupUi(this);
}

Setting::~Setting()
{
    delete ui;
}

void Setting::on_buttonClear_clicked()
{
    ui->checkBoxopen->setChecked(false);
    ui->checkBox->setChecked(true);
    ui->lineEditFip->setText(QString("0.0.0.0"));
    ui->lineEditFport->setText(QString::number(0));
}

void Setting::on_buttonConfirm_clicked()
{
    bool a=ui->checkBoxopen->isChecked();
    bool b=ui->checkBox->isChecked();
    QString c=ui->lineEditFip->text();
    QString d=ui->lineEditFport->text();
    emit(mysignal(a,b,c,d));
}

