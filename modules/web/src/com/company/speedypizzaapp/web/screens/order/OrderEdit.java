package com.company.speedypizzaapp.web.screens.order;

import com.company.speedypizzaapp.entity.OrderLine;
import com.company.speedypizzaapp.service.OrderService;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.DateField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.TimeField;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizzaapp.entity.Order;
import com.haulmont.reports.gui.actions.EditorPrintFormAction;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@UiController("speedypizzaapp_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private OrderService orderService;
    @Inject
    private DateField<LocalDateTime> orderTimeField;
    @Inject
    private TimeField<LocalTime> deliveryTimeField;
    @Inject
    private Button PrintInvoice;

    private static int orderId;


    @Subscribe
    private void onInit(InitEvent event) {

        PrintInvoice.setAction(new EditorPrintFormAction(this, null));
    }

    @Subscribe(id = "linesDc", target = Target.DATA_CONTAINER)
    private void onLinesDcCollectionChange(CollectionContainer.CollectionChangeEvent<OrderLine> event) {
        if (event.getChangeType() != CollectionChangeType.REFRESH) {
            getEditedEntity().setTotalAmount(orderService.calculateAmount(getEditedEntity())
                    .multiply(orderService.calculateDishesDiscount(getEditedEntity())
                            .multiply(orderService.calculateOrdersDiscount(getEditedEntity()))));
            getEditedEntity().setDeliveryTime(orderService.getDeliveryTime(getEditedEntity()));
            deliveryTimeField.setValue(getEditedEntity().getDeliveryTime());
        }
    }

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        if (getEditedEntity().getStaff() == null) {
            getEditedEntity().setOrderTime(orderService.getOrderTime());
            orderTimeField.setValue(getEditedEntity().getOrderTime());
            getEditedEntity().setVersion(1);
            try {
                orderId = orderService.getLastId() + 1;
            } catch (Exception ignore) {
                orderId = 0;
            }
            getEditedEntity().setOrderId("" + orderId);
        } else {
            getEditedEntity().setVersion(getEditedEntity().getVersion() + 1);
        }
    }

    @Subscribe
    private void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (getEditedEntity().getVersion() == 1) {
            getEditedEntity().getCustomer().setOrderCounter(getEditedEntity().getCustomer().getOrderCounter() + 1);
        }
    }
}