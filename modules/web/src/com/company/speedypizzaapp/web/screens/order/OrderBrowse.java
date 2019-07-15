package com.company.speedypizzaapp.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizzaapp.entity.Order;

@UiController("speedypizzaapp_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}