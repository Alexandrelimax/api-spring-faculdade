package com.projeto.springboot.projeto1.services;

import com.projeto.springboot.projeto1.entities.Product;
import com.projeto.springboot.projeto1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer id){
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product product){
        Product productDatabase = this.getProductById(id);
        if(productDatabase != null){
            productDatabase.setName(product.getName());
            return this.saveProduct(productDatabase);

        }else{
            return null;
        }
    }
    public Boolean deleteProductById(Integer id){
        Product productDatabase = this.getProductById(id);
        if(productDatabase != null){
            productRepository.delete(productDatabase);
            return true;
        }else{
            return false;
        }
    }




}
