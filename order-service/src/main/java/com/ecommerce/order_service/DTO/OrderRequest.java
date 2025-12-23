package com.ecommerce.order_service.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    // The product we are ordering (ProductService productId)
    private Long productId;

    // Quantity to order
    private Integer quantity;
}