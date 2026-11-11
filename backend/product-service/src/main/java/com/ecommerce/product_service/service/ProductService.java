package com.ecommerce.product_service.service;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.model.requestDto.ProductRequest;
import com.ecommerce.product_service.model.responseDto.ProductResponse;
import com.ecommerce.product_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public ProductResponse saveProduct (ProductRequest req){
   String name = req.getName();
   String code = req.getCode();
   Product product = new Product();
   if(productRepository.existsByNameOrCode(code,name)){
     throw new RuntimeException("product already exist with name : " + " " + req.getName() + "and code " + " " + req.getCode());
   } else {
       product.setId(req.getId());
       product.setCode(req.getCode());
       product.setName(req.getName());
       product.setQty(req.getQty());
   }
   Product prod =   productRepository.save(product);

       return ProductResponse.fromEntityToDto(prod);
   }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Integer id) {

      Product product = productRepository.findById(id)
              .orElseThrow(()->new NullPointerException("no product found with id " + " " + id));
      return product;
    }
}