package com.ecommerce.order_service.Service;

import com.ecommerce.order_service.DTO.OrderRequest;
import com.ecommerce.order_service.DTO.OrderResponse;
import com.ecommerce.order_service.DTO.ProductDto;
import com.ecommerce.order_service.Model.Order;
import com.ecommerce.order_service.OrderStatus;
import com.ecommerce.order_service.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public OrderResponse createOrder(OrderRequest request) {

        // Fetch product from Product Service (NO /api)
        ProductDto product = webClientBuilder.build()
                .get()
                .uri("http://product-service/products/{id}", request.getProductId())
                .retrieve()
                .bodyToMono(ProductDto.class)
                .block();

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        if (product.getStockQuantity() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }

        //  Save order
        Order order = Order.builder()
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .status(OrderStatus.CREATED)
                .build();

        Order savedOrder = orderRepository.save(order);

        //  Reduce stock (NO /api)
        webClientBuilder.build()
                .put()
                .uri("http://product-service/products/{id}/reduce-stock?quantity={qty}",
                        request.getProductId(), request.getQuantity())

                .retrieve()
                .toBodilessEntity()
                .block();

        //  Response
        return OrderResponse.builder()
                .orderId(savedOrder.getId())
                .productId(savedOrder.getProductId())
                .quantity(savedOrder.getQuantity())
                .status(savedOrder.getStatus())
                .productName(product.getName())
                .productPrice(product.getPrice())
                .createdAt(savedOrder.getCreatedAt())
                .createdBy(savedOrder.getCreatedBy())
                .updatedAt(savedOrder.getUpdatedAt())
                .updatedBy(savedOrder.getUpdatedBy())
                .build();
    }

    public OrderResponse getOrderById(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        // Fetch product info
        ProductDto product = webClientBuilder.build()
                .get()
                .uri("http://PRODUCT-SERVICE/products/{id}", order.getProductId())
                .retrieve()
                .bodyToMono(ProductDto.class)
                .block();

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        return OrderResponse.builder()
                .orderId(order.getId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .status(order.getStatus())
                .productName(product.getName())
                .productPrice(product.getPrice())
                .createdAt(order.getCreatedAt())
                .createdBy(order.getCreatedBy())
                .updatedAt(order.getUpdatedAt())
                .updatedBy(order.getUpdatedBy())
                .build();
    }
}
