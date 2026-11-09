package com.ecommerce.product_service.model.requestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class ProductRequest {
    private Integer id;
    private String name;
    private String code;
    private String qty;
    private String description;

}
