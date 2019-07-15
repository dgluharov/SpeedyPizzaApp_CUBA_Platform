package com.company.speedypizzaapp.service;

import com.company.speedypizzaapp.entity.Order;
import com.company.speedypizzaapp.entity.OrderLine;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FluentLoader;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {


    @Inject
    private DataManager dataManager;

    @Override
    public BigDecimal calculateAmount(Order order) {
        BigDecimal amount = BigDecimal.ZERO;
        for (OrderLine line : order.getLines()) {
            amount = amount.add(line.getDish().getPrice().multiply(line.getQuantity()));
        }
        return amount;
    }

    @Override
    public BigDecimal calculateDishesDiscount(Order order) {
        BigDecimal discount = new BigDecimal(1);
        BigDecimal count = BigDecimal.ZERO;
        for (OrderLine orderLine : order.getLines()) {
            count = count.add(orderLine.getQuantity());
        }
        if (count.compareTo(new BigDecimal(3)) > 0) {
            if (count.compareTo(new BigDecimal(10)) > 0) {
                discount = new BigDecimal(0.9);
            } else {
                discount = new BigDecimal(0.95);
            }
        }
        return discount;
    }

    @Override
    public BigDecimal calculateOrdersDiscount(Order order) {
        BigDecimal discount = new BigDecimal(1);
        if (order.getCustomer().getOrderCounter() >= 50) {
            if (order.getCustomer().getOrderCounter() >= 100) {
                discount = new BigDecimal(0.80);
            } else {
                discount = new BigDecimal(0.85);
            }
        }
        //int value = discount.intValue();
        return discount;
    }

    @Override
    public LocalDateTime getOrderTime() {
        return LocalDateTime.now();
    }

    @Override
    public LocalTime getDeliveryTime(Order order) {
        LocalTime localTime = order.getOrderTime().toLocalTime();
        localTime = localTime.plusMinutes(10);
        for (OrderLine orderLine : order.getLines()) {
            localTime = localTime.plusHours(orderLine.getDish().getCookingTime().getHour() * orderLine.getQuantity().intValue());
            localTime = localTime.plusMinutes(orderLine.getDish().getCookingTime().getMinute() * orderLine.getQuantity().intValue());
            if (orderLine.getQuantity().intValue() > 3) {
                localTime = localTime.minusMinutes(orderLine.getDish().getCookingTime().getMinute());
            }
        }
        return localTime;
    }

    @Override
    public Integer getLastId() {
        FluentLoader.ByQuery<Order, UUID> query = dataManager.load(Order.class)
                .view("order-full-view")
                .query("select o from speedypizzaapp_Order o order by o.orderId desc");
        return Integer.valueOf(query.one().getOrderId());
    }
}