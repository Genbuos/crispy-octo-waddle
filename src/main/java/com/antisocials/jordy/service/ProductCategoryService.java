package com.antisocials.jordy.service;

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
        return productCategoryRepository.findAll();
    }

    public ProductCategory getProductCategoryById(Long id){
        return productCategoryRepository.findById(id).get();
    }

    public ProductCategory updateProductCategory(ProductCategory updatedCategory, Long categoryId){
        ProductCategory ogCategory = productCategoryRepository.findById(categoryId).orElseThrow(() -> {
            return  new RuntimeException("Id not found");
        });

        ogCategory.setCategoryName(updatedCategory.getCategoryName());
        ogCategory.setProductSet(updatedCategory.getProductSet());

        return productCategoryRepository.save(ogCategory);
    }

    public void deleteCategory(Long id){
        productCategoryRepository.deleteById(id);
    }

}
