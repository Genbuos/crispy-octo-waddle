package com.antisocials.jordy.service;

import com.antisocials.jordy.exceptions.CategoryIdNotFoundException;
import com.antisocials.jordy.exceptions.NoContentException;
import com.antisocials.jordy.model.ProductCategory;
import com.antisocials.jordy.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory createProductCategory(ProductCategory productCategory){
    return productCategoryRepository.save(productCategory);
    }

    public Iterable<ProductCategory> getAllCategories(){

        if(productCategoryRepository.findAll().size() == 0){
            throw new NoContentException("There are no products or categories created!");
        }

        return productCategoryRepository.findAll();
    }

    public ProductCategory getProductCategoryById(Long id){
        var categoryOptional = productCategoryRepository.findById(id);
        if(categoryOptional.isEmpty()){
            throw new CategoryIdNotFoundException("Category ID Not Found");
        }
        return categoryOptional.get();
    }

    public ProductCategory updateProductCategory(ProductCategory updatedCategory, Long categoryId){
        ProductCategory ogCategory = productCategoryRepository.findById(categoryId).orElseThrow(() -> {
            return  new CategoryIdNotFoundException("Category ID Not Found");
        });

        ogCategory.setCategoryName(updatedCategory.getCategoryName());


        return productCategoryRepository.save(ogCategory);
    }

    public void deleteCategory(Long id){
        if(!productCategoryRepository.existsById(id)){
            throw new CategoryIdNotFoundException("Category ID Not Found");
        }

        productCategoryRepository.deleteById(id);
    }

}
