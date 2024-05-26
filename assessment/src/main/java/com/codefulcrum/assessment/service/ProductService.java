package com.codefulcrum.assessment.service;

import com.codefulcrum.assessment.dto.ProductRequestDTO;
import com.codefulcrum.assessment.dto.ProductResponseDTO;

public interface ProductService {
    void createProduct(ProductRequestDTO productRequestDTO);
    void updateProduct(String id,ProductRequestDTO productRequestDTO);
    void deleteProduct(String id);
    ProductResponseDTO getProductsByCriteria(Long pageNumber, Long pageSize, Boolean isExpired);
}
