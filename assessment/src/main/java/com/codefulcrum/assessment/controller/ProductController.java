package com.codefulcrum.assessment.controller;

import com.codefulcrum.assessment.dto.ApiResponse;
import com.codefulcrum.assessment.dto.ProductRequestDTO;
import com.codefulcrum.assessment.dto.ProductResponseDTO;
import com.codefulcrum.assessment.service.ProductService;
import com.codefulcrum.assessment.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<?>> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        productService.createProduct(productRequestDTO);
        return new ResponseEntity<>(new ApiResponse<>(Constants.STATUS_CODE_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE,
                        null), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateProduct(@PathVariable("id") String id, @Valid @RequestBody ProductRequestDTO productRequestDTO) {
        productService.updateProduct(id,productRequestDTO);
        return new ResponseEntity<>(new ApiResponse<>(Constants.STATUS_CODE_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE,
                null), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(new ApiResponse<>(Constants.STATUS_CODE_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE,
                null), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<ApiResponse<ProductResponseDTO>> getProductsByCriteria(
            @RequestParam(defaultValue = "10") Long pageSize,
            @RequestParam(defaultValue = "0") Long pageNumber,
            @RequestParam(required = false,defaultValue = "false") Boolean isExpired) {
        return new ResponseEntity<>(new ApiResponse<>(Constants.STATUS_CODE_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE,
                productService.getProductsByCriteria(pageNumber,pageSize,isExpired)), HttpStatus.OK);

    }
}
