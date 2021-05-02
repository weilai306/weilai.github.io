/********************************************************************************
** Form generated from reading UI file 'setting.ui'
**
** Created by: Qt User Interface Compiler version 5.12.9
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_SETTING_H
#define UI_SETTING_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QCheckBox>
#include <QtWidgets/QDialog>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>

QT_BEGIN_NAMESPACE

class Ui_Setting
{
public:
    QGridLayout *gridLayout_2;
    QPushButton *buttonClear;
    QGridLayout *gridLayout;
    QLineEdit *lineEditFip;
    QCheckBox *checkBox;
    QLineEdit *lineEditFport;
    QLabel *label_3;
    QLabel *label_2;
    QLabel *label;
    QCheckBox *checkBoxopen;
    QPushButton *buttonConfirm;

    void setupUi(QDialog *Setting)
    {
        if (Setting->objectName().isEmpty())
            Setting->setObjectName(QString::fromUtf8("Setting"));
        Setting->resize(400, 252);
        gridLayout_2 = new QGridLayout(Setting);
        gridLayout_2->setObjectName(QString::fromUtf8("gridLayout_2"));
        buttonClear = new QPushButton(Setting);
        buttonClear->setObjectName(QString::fromUtf8("buttonClear"));

        gridLayout_2->addWidget(buttonClear, 2, 1, 1, 1);

        gridLayout = new QGridLayout();
        gridLayout->setObjectName(QString::fromUtf8("gridLayout"));
        lineEditFip = new QLineEdit(Setting);
        lineEditFip->setObjectName(QString::fromUtf8("lineEditFip"));

        gridLayout->addWidget(lineEditFip, 2, 2, 1, 1);

        checkBox = new QCheckBox(Setting);
        checkBox->setObjectName(QString::fromUtf8("checkBox"));
        checkBox->setChecked(true);
        checkBox->setTristate(false);

        gridLayout->addWidget(checkBox, 1, 2, 1, 1);

        lineEditFport = new QLineEdit(Setting);
        lineEditFport->setObjectName(QString::fromUtf8("lineEditFport"));

        gridLayout->addWidget(lineEditFport, 3, 2, 1, 1);

        label_3 = new QLabel(Setting);
        label_3->setObjectName(QString::fromUtf8("label_3"));

        gridLayout->addWidget(label_3, 3, 0, 1, 1);

        label_2 = new QLabel(Setting);
        label_2->setObjectName(QString::fromUtf8("label_2"));

        gridLayout->addWidget(label_2, 2, 0, 1, 1);

        label = new QLabel(Setting);
        label->setObjectName(QString::fromUtf8("label"));

        gridLayout->addWidget(label, 1, 0, 1, 2);

        checkBoxopen = new QCheckBox(Setting);
        checkBoxopen->setObjectName(QString::fromUtf8("checkBoxopen"));

        gridLayout->addWidget(checkBoxopen, 0, 0, 1, 3);


        gridLayout_2->addLayout(gridLayout, 0, 0, 1, 2);

        buttonConfirm = new QPushButton(Setting);
        buttonConfirm->setObjectName(QString::fromUtf8("buttonConfirm"));

        gridLayout_2->addWidget(buttonConfirm, 2, 0, 1, 1);


        retranslateUi(Setting);

        QMetaObject::connectSlotsByName(Setting);
    } // setupUi

    void retranslateUi(QDialog *Setting)
    {
        Setting->setWindowTitle(QApplication::translate("Setting", "Dialog", nullptr));
        buttonClear->setText(QApplication::translate("Setting", "Clear", nullptr));
        lineEditFip->setText(QApplication::translate("Setting", "0.0.0.0", nullptr));
        checkBox->setText(QApplication::translate("Setting", "\357\274\210\351\273\230\350\256\244\345\274\200\345\220\257\357\274\211", nullptr));
        lineEditFport->setText(QApplication::translate("Setting", "0", nullptr));
        label_3->setText(QApplication::translate("Setting", "\350\277\207\346\273\244\347\253\257\345\217\243", nullptr));
        label_2->setText(QApplication::translate("Setting", "\350\277\207\346\273\244IP", nullptr));
        label->setText(QApplication::translate("Setting", "\345\217\252\346\230\276\347\244\272\345\220\253\346\225\260\346\215\256\347\232\204\350\277\236\346\216\245", nullptr));
        checkBoxopen->setText(QApplication::translate("Setting", "\345\274\200\345\220\257\350\277\207\346\273\244\345\231\250", nullptr));
        buttonConfirm->setText(QApplication::translate("Setting", "Confirm", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Setting: public Ui_Setting {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_SETTING_H
