package com.projeto.springboot.projeto1.controllers;

import com.projeto.springboot.projeto1.entities.Category;
import com.projeto.springboot.projeto1.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categoriesList = categoryService.getAll();
        if(!categoriesList.isEmpty()){
            return new ResponseEntity<>(categoriesList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
        Category category = categoryService.getCategoryById(id);
        if(category != null){
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category newCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id,
                                                 @RequestBody Category newCategory){
        Category categoryUpdated = categoryService.updateCategory(id, newCategory);
        if(categoryUpdated != null){
            return new ResponseEntity<>(categoryUpdated, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable Integer id){
        if(categoryService.deleteCategoryById(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

    }
}
