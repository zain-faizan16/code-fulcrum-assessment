package com.codefulcrum.assessment.repository;

import com.codefulcrum.assessment.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;

public interface ProductRepository {
    void saveProduct(Product product);
    Product getById(String id);
    void updateProduct(Product product);
    void deleteById(String id);
    Page<Product> getProductsByCriteria(Long pageNumber, Long pageSize, Boolean isExpired);
}
