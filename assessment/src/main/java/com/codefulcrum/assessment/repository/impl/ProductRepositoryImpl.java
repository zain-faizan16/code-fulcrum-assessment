package com.codefulcrum.assessment.repository.impl;

import com.codefulcrum.assessment.entity.Product;
import com.codefulcrum.assessment.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private static final String INSERT_PRODUCT_QUERY = "INSERT INTO PRODUCT(name,category,quantity,definition) values(?,?,?,?)";
    private static final String UPDATE_PRODUCT_BY_ID_QUERY = "UPDATE PRODUCT SET name = ?,category = ?,quantity= ?,definition=? WHERE Id=?";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM PRODUCT WHERE ID=?";
    private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM PRODUCT WHERE ID=?";
    private static final String GET_PRODUCT_BY_CRITERIA = "CALL GetProductsBYCriteria(?, ?,?)";
    private static final String GET_PRODUCT_COUNT_BY_CRITERIA = "call GetProductCountBYCriteria(?)";
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void saveProduct(Product product) {
        jdbcTemplate.update(INSERT_PRODUCT_QUERY, product.getName(), product.getCategory(), product.getQuantity(), product.getDefinition());
    }
    @Override
    public Product getById(String id) {
        return jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID_QUERY, (rs, rowNum) -> {

            return new Product(rs.getString("id"), rs.getString("name"), rs.getString("category"),
                    rs.getLong("quantity"),rs.getString("definition"),rs.getDate("createdAt")
                    ,rs.getDate("updatedAt"));
        },id);
    }

    @Override
    public void updateProduct(Product product) {
        jdbcTemplate.update(UPDATE_PRODUCT_BY_ID_QUERY, product.getName(), product.getCategory(), product.getQuantity(), product.getDefinition(),product.getId());
    }

    @Override
    public void deleteById(String id) {
        jdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);
    }

    public Page<Product> getProductsByCriteria(Long pageNumber, Long pageSize, Boolean isExpired){
        long totalElements = jdbcTemplate.queryForObject(GET_PRODUCT_COUNT_BY_CRITERIA, Long.class,isExpired);
        List<Product> content = jdbcTemplate.query(GET_PRODUCT_BY_CRITERIA, BeanPropertyRowMapper.newInstance(Product.class), pageSize, pageNumber,isExpired);
        Pageable pageable = PageRequest.of(pageNumber.intValue(), pageSize.intValue());
        return new PageImpl<>(content, pageable, totalElements);
    }
}