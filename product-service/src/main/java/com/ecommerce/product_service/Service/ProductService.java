package com.ecommerce.product_service.Service;

import com.ecommerce.product_service.DTO.ProductRequest;
import com.ecommerce.product_service.DTO.ProductResponse;
import com.ecommerce.product_service.Model.Product;
import com.ecommerce.product_service.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;

import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class ProductService {

    private final ProductRepository productRepository;

    // CREATE PRODUCT
    public ProductResponse createProduct(ProductRequest request) {

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .build();

        Product savedProduct = productRepository.save(product);

        return buildProductResponse(savedProduct);
    }

    // GET ALL PRODUCTS (NO STREAM)
    public List<ProductResponse> getAllProducts() {

        List<Product> products = productRepository.findAll();
        List<ProductResponse> responseList = new ArrayList<>();

        for (Product product : products) {
            responseList.add(buildProductResponse(product));
        }

        return responseList;
    }

    // GET PRODUCT BY ID
    public ProductResponse getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Product not found with id: " + id)
                );

        return buildProductResponse(product);
    }

    @Transactional
    public void reduceStock(Long productId, Integer quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStockQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        product.setStockQuantity(product.getStockQuantity() - quantity);
        productRepository.save(product);
    }


    // ENTITY → DTO (BUILDER)
    private ProductResponse buildProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .createdAt(product.getCreatedAt())
                .createdBy(product.getCreatedBy())
                .updatedAt(product.getUpdatedAt())
                .updatedBy(product.getUpdatedBy())
                .build();
    }


}
