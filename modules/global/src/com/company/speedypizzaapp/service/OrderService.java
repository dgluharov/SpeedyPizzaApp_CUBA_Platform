package com.company.speedypizzaapp.service;

import com.company.speedypizzaapp.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface OrderService {
    String NAME = "speedypizzaapp_OrderService";

    BigDecimal calculateAmount(Order order);

    BigDecimal calculateDishesDiscount(Order order);

    BigDecimal calculateOrdersDiscount(Order order);

    LocalDateTime getOrderTime();

    LocalTime getDeliveryTime(Order order);

    Integer getLastId();
}