/********************************************************************************
** Form generated from reading UI file 'widget.ui'
**
** Created by: Qt User Interface Compiler version 5.12.9
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_WIDGET_H
#define UI_WIDGET_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QTableWidget>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Widget
{
public:
    QGridLayout *gridLayout_2;
    QGridLayout *gridLayout;
    QLabel *label;
    QLineEdit *lineEditIp;
    QPushButton *buttonSetting;
    QLabel *label_2;
    QLineEdit *lineEditPort;
    QPushButton *buttonbind;
    QLabel *label_3;
    QTableWidget *tableWidget;
    QTextEdit *textEditData;
    QLabel *labelStatus;
    QGridLayout *gridLayout_3;
    QSpacerItem *horizontalSpacer;
    QPushButton *buttonClear;
    QSpacerItem *horizontalSpacer_3;
    QPushButton *buttonClose;
    QSpacerItem *horizontalSpacer_2;

    void setupUi(QWidget *Widget)
    {
        if (Widget->objectName().isEmpty())
            Widget->setObjectName(QString::fromUtf8("Widget"));
        Widget->resize(655, 581);
        gridLayout_2 = new QGridLayout(Widget);
        gridLayout_2->setObjectName(QString::fromUtf8("gridLayout_2"));
        gridLayout = new QGridLayout();
        gridLayout->setObjectName(QString::fromUtf8("gridLayout"));
        label = new QLabel(Widget);
        label->setObjectName(QString::fromUtf8("label"));

        gridLayout->addWidget(label, 0, 0, 1, 1);

        lineEditIp = new QLineEdit(Widget);
        lineEditIp->setObjectName(QString::fromUtf8("lineEditIp"));

        gridLayout->addWidget(lineEditIp, 0, 1, 1, 1);

        buttonSetting = new QPushButton(Widget);
        buttonSetting->setObjectName(QString::fromUtf8("buttonSetting"));

        gridLayout->addWidget(buttonSetting, 0, 2, 1, 1);

        label_2 = new QLabel(Widget);
        label_2->setObjectName(QString::fromUtf8("label_2"));

        gridLayout->addWidget(label_2, 1, 0, 1, 1);

        lineEditPort = new QLineEdit(Widget);
        lineEditPort->setObjectName(QString::fromUtf8("lineEditPort"));

        gridLayout->addWidget(lineEditPort, 1, 1, 1, 1);

        buttonbind = new QPushButton(Widget);
        buttonbind->setObjectName(QString::fromUtf8("buttonbind"));

        gridLayout->addWidget(buttonbind, 1, 2, 1, 1);


        gridLayout_2->addLayout(gridLayout, 0, 0, 1, 1);

        label_3 = new QLabel(Widget);
        label_3->setObjectName(QString::fromUtf8("label_3"));

        gridLayout_2->addWidget(label_3, 1, 0, 1, 1);

        tableWidget = new QTableWidget(Widget);
        if (tableWidget->columnCount() < 6)
            tableWidget->setColumnCount(6);
        if (tableWidget->rowCount() < 1)
            tableWidget->setRowCount(1);
        QTableWidgetItem *__qtablewidgetitem = new QTableWidgetItem();
        tableWidget->setVerticalHeaderItem(0, __qtablewidgetitem);
        QTableWidgetItem *__qtablewidgetitem1 = new QTableWidgetItem();
        __qtablewidgetitem1->setFlags(Qt::ItemIsSelectable|Qt::ItemIsDragEnabled|Qt::ItemIsDropEnabled|Qt::ItemIsUserCheckable|Qt::ItemIsEnabled);
        tableWidget->setItem(0, 0, __qtablewidgetitem1);
        QTableWidgetItem *__qtablewidgetitem2 = new QTableWidgetItem();
        __qtablewidgetitem2->setFlags(Qt::ItemIsSelectable|Qt::ItemIsDragEnabled|Qt::ItemIsDropEnabled|Qt::ItemIsUserCheckable|Qt::ItemIsEnabled);
        tableWidget->setItem(0, 1, __qtablewidgetitem2);
        QTableWidgetItem *__qtablewidgetitem3 = new QTableWidgetItem();
        __qtablewidgetitem3->setFlags(Qt::ItemIsSelectable|Qt::ItemIsDragEnabled|Qt::ItemIsDropEnabled|Qt::ItemIsUserCheckable|Qt::ItemIsEnabled);
        tableWidget->setItem(0, 2, __qtablewidgetitem3);
        QTableWidgetItem *__qtablewidgetitem4 = new QTableWidgetItem();
        __qtablewidgetitem4->setFlags(Qt::ItemIsSelectable|Qt::ItemIsDragEnabled|Qt::ItemIsDropEnabled|Qt::ItemIsUserCheckable|Qt::ItemIsEnabled);
        tableWidget->setItem(0, 3, __qtablewidgetitem4);
        QTableWidgetItem *__qtablewidgetitem5 = new QTableWidgetItem();
        __qtablewidgetitem5->setFlags(Qt::ItemIsSelectable|Qt::ItemIsDragEnabled|Qt::ItemIsDropEnabled|Qt::ItemIsUserCheckable|Qt::ItemIsEnabled);
        tableWidget->setItem(0, 4, __qtablewidgetitem5);
        QTableWidgetItem *__qtablewidgetitem6 = new QTableWidgetItem();
        __qtablewidgetitem6->setFlags(Qt::ItemIsSelectable|Qt::ItemIsDragEnabled|Qt::ItemIsDropEnabled|Qt::ItemIsUserCheckable|Qt::ItemIsEnabled);
        tableWidget->setItem(0, 5, __qtablewidgetitem6);
        tableWidget->setObjectName(QString::fromUtf8("tableWidget"));
        tableWidget->setEditTriggers(QAbstractItemView::NoEditTriggers);
        tableWidget->setColumnCount(6);
        tableWidget->horizontalHeader()->setVisible(false);
        tableWidget->horizontalHeader()->setHighlightSections(true);
        tableWidget->verticalHeader()->setVisible(true);

        gridLayout_2->addWidget(tableWidget, 2, 0, 1, 1);

        textEditData = new QTextEdit(Widget);
        textEditData->setObjectName(QString::fromUtf8("textEditData"));
        textEditData->setReadOnly(true);

        gridLayout_2->addWidget(textEditData, 3, 0, 1, 1);

        labelStatus = new QLabel(Widget);
        labelStatus->setObjectName(QString::fromUtf8("labelStatus"));

        gridLayout_2->addWidget(labelStatus, 4, 0, 1, 1);

        gridLayout_3 = new QGridLayout();
        gridLayout_3->setObjectName(QString::fromUtf8("gridLayout_3"));
        horizontalSpacer = new QSpacerItem(187, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout_3->addItem(horizontalSpacer, 0, 0, 1, 1);

        buttonClear = new QPushButton(Widget);
        buttonClear->setObjectName(QString::fromUtf8("buttonClear"));

        gridLayout_3->addWidget(buttonClear, 0, 1, 1, 1);

        horizontalSpacer_3 = new QSpacerItem(176, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout_3->addItem(horizontalSpacer_3, 0, 2, 1, 1);

        buttonClose = new QPushButton(Widget);
        buttonClose->setObjectName(QString::fromUtf8("buttonClose"));

        gridLayout_3->addWidget(buttonClose, 0, 3, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(175, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout_3->addItem(horizontalSpacer_2, 0, 4, 1, 1);


        gridLayout_2->addLayout(gridLayout_3, 5, 0, 1, 1);


        retranslateUi(Widget);

        QMetaObject::connectSlotsByName(Widget);
    } // setupUi

    void retranslateUi(QWidget *Widget)
    {
        Widget->setWindowTitle(QApplication::translate("Widget", "Widget", nullptr));
        label->setText(QApplication::translate("Widget", "IP", nullptr));
        lineEditIp->setText(QApplication::translate("Widget", "127.0.0.1", nullptr));
        buttonSetting->setText(QApplication::translate("Widget", "Setting", nullptr));
        label_2->setText(QApplication::translate("Widget", "Port", nullptr));
        lineEditPort->setText(QApplication::translate("Widget", "0", nullptr));
        buttonbind->setText(QApplication::translate("Widget", "Start", nullptr));
        label_3->setText(QApplication::translate("Widget", "MessageTable", nullptr));

        const bool __sortingEnabled = tableWidget->isSortingEnabled();
        tableWidget->setSortingEnabled(false);
        QTableWidgetItem *___qtablewidgetitem = tableWidget->item(0, 0);
        ___qtablewidgetitem->setText(QApplication::translate("Widget", "\346\272\220IP\345\234\260\345\235\200", nullptr));
        QTableWidgetItem *___qtablewidgetitem1 = tableWidget->item(0, 1);
        ___qtablewidgetitem1->setText(QApplication::translate("Widget", "\346\272\220\347\253\257\345\217\243\345\217\267", nullptr));
        QTableWidgetItem *___qtablewidgetitem2 = tableWidget->item(0, 2);
        ___qtablewidgetitem2->setText(QApplication::translate("Widget", "\347\233\256\347\232\204IP\345\234\260\345\235\200", nullptr));
        QTableWidgetItem *___qtablewidgetitem3 = tableWidget->item(0, 3);
        ___qtablewidgetitem3->setText(QApplication::translate("Widget", "\347\233\256\347\232\204\347\253\257\345\217\243\345\217\267", nullptr));
        QTableWidgetItem *___qtablewidgetitem4 = tableWidget->item(0, 4);
        ___qtablewidgetitem4->setText(QApplication::translate("Widget", "\346\212\245\346\226\207\345\255\227\350\212\202\346\225\260", nullptr));
        QTableWidgetItem *___qtablewidgetitem5 = tableWidget->item(0, 5);
        ___qtablewidgetitem5->setText(QApplication::translate("Widget", "\346\225\260\346\215\256\345\206\205\345\256\271", nullptr));
        tableWidget->setSortingEnabled(__sortingEnabled);

        labelStatus->setText(QApplication::translate("Widget", "\346\234\215\345\212\241\346\234\252\345\220\257\345\212\250\357\274\201", nullptr));
        buttonClear->setText(QApplication::translate("Widget", "Clear", nullptr));
        buttonClose->setText(QApplication::translate("Widget", "Close", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Widget: public Ui_Widget {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_WIDGET_H
