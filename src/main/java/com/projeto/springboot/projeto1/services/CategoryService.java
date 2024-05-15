package com.projeto.springboot.projeto1.services;

import com.projeto.springboot.projeto1.entities.Category;
import com.projeto.springboot.projeto1.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category product){
        return categoryRepository.save(product);
    }

    public Category updateCategory(Integer id, Category category){
        Category categoryDatabase = this.getCategoryById(id);
        if(categoryDatabase != null){
            categoryDatabase.setName(category.getName());
            return this.saveCategory(categoryDatabase);

        }else{
            return null;
        }
    }
    public Boolean deleteCategoryById(Integer id){
        Category categoryDatabase = this.getCategoryById(id);
        if(categoryDatabase != null){
            categoryRepository.delete(categoryDatabase);
            return true;
        }else{
            return false;
        }
    }
}
