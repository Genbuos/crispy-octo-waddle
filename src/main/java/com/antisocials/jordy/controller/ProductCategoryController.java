package com.antisocials.jordy.controller;

import com.antisocials.jordy.model.ProductCategory;
import com.antisocials.jordy.response.ProductCategoryResponse;
import com.antisocials.jordy.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryResponse productCategoryResponse;

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories(){
        return productCategoryResponse.getAllCategories();
    }

    @PostMapping("/categories")
    public ResponseEntity<?> createCategory(@RequestBody ProductCategory productCategory){
        return productCategoryResponse.createProductCategory(productCategory);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId){
        return productCategoryResponse.getCategoryById(categoryId);
    }


@PutMapping("/categories/{cid}")
    public ResponseEntity<?> updateCategory(@RequestBody ProductCategory productCategory, @PathVariable Long cid){
        return productCategoryResponse.updateProductCategory(productCategory, cid);
    }

    @DeleteMapping("/categories/{cid}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long cid){
        return productCategoryResponse.deleteCategory(cid);
    }
}
