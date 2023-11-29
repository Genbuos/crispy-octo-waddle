package com.antisocials.jordy.response;

import com.antisocials.jordy.dto.Detail;
import com.antisocials.jordy.model.ProductCategory;
import com.antisocials.jordy.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryResponse {

    @Autowired
    private ProductCategoryService productCategoryService;

    public ResponseEntity<?> createProductCategory(ProductCategory productCategory){
        Detail detail = new Detail();
        detail.setCode(HttpStatus.CREATED.value());
        detail.setData(productCategoryService.createProductCategory(productCategory));
        return new ResponseEntity<>(detail, HttpStatus.CREATED);

    }

    public ResponseEntity<?> getAllCategories(){
        Detail detail = new Detail();
        detail.setCode(HttpStatus.OK.value());
        detail.setData(productCategoryService.getAllCategories());
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<?> getCategoryById(Long id){
        Detail detail = new Detail();
        detail.setCode(HttpStatus.OK.value());
        detail.setData(productCategoryService.getProductCategoryById(id));
        return new ResponseEntity<>(detail, HttpStatus.OK);

    }

    public ResponseEntity<?> updateProductCategory(ProductCategory productCategory, Long cid){
        Detail detail = new Detail();
        detail.setCode(HttpStatus.OK.value());
        detail.setData(productCategoryService.updateProductCategory(productCategory, cid));
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCategory(Long id){
        Detail detail = new Detail();
        productCategoryService.deleteCategory(id);
        detail.setCode(HttpStatus.NO_CONTENT.value());
       return new ResponseEntity<>(detail, HttpStatus.NO_CONTENT);
    }

}
