package com.antisocials.jordy.service;

import com.antisocials.jordy.model.Product;
import com.antisocials.jordy.repositories.ProductCategoryRepository;
import com.antisocials.jordy.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;




    public Product createProduct(Product product, Long cid){

        var categoryOptional = productCategoryRepository.findById(cid);
        if(categoryOptional.isEmpty()){
           throw new RuntimeException("Category id does not exist!");
        }
            product.setProductCategory(categoryOptional.get());
        productRepository.save(product);

            categoryOptional.get().getProductSet().add(product);
            productCategoryRepository.save(categoryOptional.get());
            return product;

    }


    public Iterable<Product> getAllProducts(){
    return  productRepository.findAll();
    }

    public Product getProductById(Long productId){
        return productRepository.findById(productId).get();
    }

public Product updateProduct(Product updatedProduct, Long productId){
        Product ogProduct = productRepository.findById(productId).orElseThrow(() -> {
            return  new RuntimeException("Id does not exist");
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
