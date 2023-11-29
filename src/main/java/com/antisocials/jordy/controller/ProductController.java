package com.antisocials.jordy.controller;

import com.antisocials.jordy.model.Product;
import com.antisocials.jordy.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductResponse productResponse;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        return productResponse.getAllProducts();
    }

    @PostMapping("/products/{cid}")
    public ResponseEntity<?> createProduct(@RequestBody Product product, @PathVariable Long cid){
        return productResponse.createProduct(product, cid);
    }


    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId){
        return productResponse.getProductById(productId);
    }
    @PutMapping("/products/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long productId){
        return productResponse.updateProduct(product, productId);
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return productResponse.deleteProduct(id);
    }






}
