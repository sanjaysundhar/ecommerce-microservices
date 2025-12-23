package com.ecommerce.order_service;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum OrderStatus {
    CREATED,
    CONFIRMED,
    CANCELLED
}
