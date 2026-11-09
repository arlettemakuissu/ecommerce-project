package com.ecommerce.product_service.controller;


import com.ecommerce.product_service.model.requestDto.ProductRequest;
import com.ecommerce.product_service.model.responseDto.ProductResponse;
import com.ecommerce.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class controller {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> save(ProductRequest req){
     ProductResponse productResponse = productService.saveProduct(req);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }
}
