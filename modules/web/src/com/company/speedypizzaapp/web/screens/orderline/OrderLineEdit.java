package com.company.speedypizzaapp.web.screens.orderline;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizzaapp.entity.OrderLine;

@UiController("speedypizzaapp_OrderLine.edit")
@UiDescriptor("order-line-edit.xml")
@EditedEntityContainer("orderLineDc")
@LoadDataBeforeShow
public class OrderLineEdit extends StandardEditor<OrderLine> {
}