package com.ecommerce.order_service.Repository;

import com.ecommerce.order_service.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}