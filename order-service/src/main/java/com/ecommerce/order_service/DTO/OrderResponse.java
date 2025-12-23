package com.ecommerce.order_service.DTO;

import com.ecommerce.order_service.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private Long orderId;
    private Long productId;
    private Integer quantity;
    private OrderStatus status;


    private String productName;
    private BigDecimal productPrice;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
