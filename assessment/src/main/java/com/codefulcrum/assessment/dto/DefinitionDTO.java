package com.codefulcrum.assessment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
@Data
@JsonInclude
public class DefinitionDTO {
    @JsonProperty("manufacturing_date")
    private Date manufacturingDate;

    @JsonProperty("expiry_date")
    private Date expiryDate;

    private BigDecimal price;

    // Constructor, getters, and setters
}

