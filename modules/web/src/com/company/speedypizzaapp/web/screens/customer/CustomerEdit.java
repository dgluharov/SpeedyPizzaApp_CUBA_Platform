package com.company.speedypizzaapp.web.screens.customer;

import com.company.speedypizzaapp.entity.Order;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizzaapp.entity.Customer;

import javax.inject.Inject;

@UiController("speedypizzaapp_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {


    @Inject
    private CollectionLoader<Order> ordersDl;
    @Inject
    private InstanceLoader<Customer> customerDl;
    @Inject
    private InstanceContainer<Customer> customerDc;

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        customerDl.load();
        ordersDl.setParameter("customer", customerDc.getItem());
        ordersDl.load();
    }


}