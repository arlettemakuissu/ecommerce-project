package com.ecommerce.product_service.controller;


import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.model.requestDto.ProductRequest;
import com.ecommerce.product_service.model.responseDto.ProductResponse;
import com.ecommerce.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class controller {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody  ProductRequest req){
     ProductResponse productResponse = productService.saveProduct(req);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
         System.out.println("helloooooooo");
        List<Product> products = productService.getProducts();

        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){

        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
