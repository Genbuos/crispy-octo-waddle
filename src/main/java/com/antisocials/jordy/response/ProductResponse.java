package com.antisocials.jordy.response;

import com.antisocials.jordy.dto.Detail;
import com.antisocials.jordy.model.Product;
import com.antisocials.jordy.repositories.ProductRepository;
import com.antisocials.jordy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductResponse {
    @Autowired
    private ProductService productService;


    public ResponseEntity<?> createProduct(Product product, Long cid){
        Detail detail = new Detail();
       var p = productService.createProduct(product, cid);
        detail.setCode(HttpStatus.CREATED.value());
        detail.setData(p);
        return new ResponseEntity<>(detail, HttpStatus.CREATED);
    }


    public ResponseEntity<?> getAllProducts(){
        Detail detail = new Detail();
        detail.setCode(HttpStatus.OK.value());
        detail.setData(productService.getAllProducts());
        return  new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<?> getProductById(Long productId){
        Detail detail = new Detail();
        detail.setCode(HttpStatus.OK.value());
        detail.setData(productService.getProductById(productId));
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<?> updateProduct(Product product, Long productId){
        Detail detail = new Detail();
        detail.setCode(HttpStatus.ACCEPTED.value());
        detail.setData(productService.updateProduct(product, productId));
        return  new ResponseEntity<>(detail, HttpStatus.ACCEPTED);
    }


    public ResponseEntity<?> deleteProduct(Long id){
        productService.deleteProduct(id);
        Detail detail = new Detail();
        detail.setCode(HttpStatus.NO_CONTENT.value());

        return new ResponseEntity<>(detail, HttpStatus.NO_CONTENT);
    }


}
