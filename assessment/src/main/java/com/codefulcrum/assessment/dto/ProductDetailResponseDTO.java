package com.codefulcrum.assessment.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import java.util.Date;

@Data
public class ProductDetailResponseDTO {
    private String id;
    private String name;
    private String category;
    private Long quantity;
    private DefinitionDTO definition;
    private Date createdAt;
    private Date updatedAt;

    public void setDefinition(String definition) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.definition = objectMapper.readValue(definition,DefinitionDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
