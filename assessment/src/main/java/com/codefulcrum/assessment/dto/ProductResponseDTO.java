package com.codefulcrum.assessment.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProductResponseDTO {
    private List<ProductDetailResponseDTO> productDetailResponseDTOS;
    private Long pageNumber;
    private Long pageSize;
    private Long totalElements;
    private Long totalPages;
}
