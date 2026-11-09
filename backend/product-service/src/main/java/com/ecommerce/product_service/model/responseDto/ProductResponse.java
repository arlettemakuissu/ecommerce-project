package com.ecommerce.product_service.model.responseDto;

import com.ecommerce.product_service.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    private Integer id;
    private String name;
    private String code;
    private String qty;


    public static ProductResponse fromEntityToDto(Product product){
        return new ProductResponse(
            product.getId(),
            product.getCode(),
            product.getName(),
            product.getQty()
        );
    }
}
