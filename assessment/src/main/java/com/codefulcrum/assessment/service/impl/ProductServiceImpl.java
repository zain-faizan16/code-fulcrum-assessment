package com.codefulcrum.assessment.service.impl;

import com.codefulcrum.assessment.dto.ProductDetailResponseDTO;
import com.codefulcrum.assessment.dto.ProductRequestDTO;
import com.codefulcrum.assessment.dto.ProductResponseDTO;
import com.codefulcrum.assessment.entity.Product;
import com.codefulcrum.assessment.repository.ProductRepository;
import com.codefulcrum.assessment.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequestDTO productRequestDTO){
        productRepository.saveProduct(modelMapper.map(productRequestDTO, Product.class));
    }

    @Override
    public void updateProduct(String id,ProductRequestDTO productRequestDTO){
        Product product = productRepository.getById(id);
        modelMapper.map(productRequestDTO,product);
        productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponseDTO getProductsByCriteria(Long pageNumber, Long pageSize, Boolean isExpired){
        Page<Product> products = productRepository.getProductsByCriteria(pageNumber,pageSize,isExpired);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductDetailResponseDTOS(products.stream().map(product -> modelMapper.map
                (product, ProductDetailResponseDTO.class)).collect(Collectors.toList()));
        productResponseDTO.setPageSize(Long.valueOf(products.getContent().size()));
        productResponseDTO.setPageNumber(Long.valueOf(products.getNumber()));
        productResponseDTO.setTotalPages(Long.valueOf(products.getTotalPages()));
        productResponseDTO.setTotalElements(Long.valueOf(products.getTotalElements()));
        return productResponseDTO;
    }

}
