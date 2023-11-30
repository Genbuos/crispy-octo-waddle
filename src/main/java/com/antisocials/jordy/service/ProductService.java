package com.antisocials.jordy.service;

import com.antisocials.jordy.exceptions.CategoryIdNotFoundException;
import com.antisocials.jordy.exceptions.NoContentException;
import com.antisocials.jordy.exceptions.ProductIdNotFoundException;
import com.antisocials.jordy.model.Product;
import com.antisocials.jordy.repositories.ProductCategoryRepository;
import com.antisocials.jordy.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    private final Logger logger = LoggerFactory.getLogger(ProductService.class);


    public Product createProduct(Product product, Long cid){

        var categoryOptional = productCategoryRepository.findById(cid);
        if(categoryOptional.isEmpty()){
           throw new CategoryIdNotFoundException("Category ID Not Found");
        }
            product.setProductCategory(categoryOptional.get());

        logger.info("Product added to category set");


        productRepository.save(product);


            productCategoryRepository.save(categoryOptional.get());
            return product;

    }


    public Iterable<Product> getAllProducts(){
        if(productRepository.findAll().size() == 0){
            throw new NoContentException("There are no products or categories created!");
        }


    return productRepository.findAll() ;
    }

    public Product getProductById(Long productId){

        var productOp = productRepository.findById(productId);

        if(productOp.isEmpty()){
            throw new ProductIdNotFoundException("Product with id: " + productId + " does not exist");
        }

        return productOp.get();
    }

public Product updateProduct(Product updatedProduct, Long productId){
        Product ogProduct = productRepository.findById(productId).orElseThrow(() -> {
            return   new NoContentException("There are no products or categories created!");
        });

        ogProduct.setSku(updatedProduct.getSku());
        ogProduct.setName(updatedProduct.getName());
        ogProduct.setProductCategory(updatedProduct.getProductCategory());
        ogProduct.setDescription(updatedProduct.getDescription());
        ogProduct.setUnitPrice(updatedProduct.getUnitPrice());
        ogProduct.setImage_url(updatedProduct.getImage_url());
        ogProduct.setActive(updatedProduct.isActive());

        return productRepository.save(ogProduct);
}

public void deleteProduct(Long id ){
        productRepository.deleteById(id);
}



}
