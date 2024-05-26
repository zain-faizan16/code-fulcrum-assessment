package com.codefulcrum.assessment.entity;

import com.codefulcrum.assessment.dto.DefinitionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private String category;
    private Long quantity;
    private String definition;
    private Date createdAt;
    private Date updatedAt;

    public void setDefinition(DefinitionDTO definition) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.definition = objectMapper.writeValueAsString(definition);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }

}
