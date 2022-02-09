package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.Category;
import com.cs4.clothes.model.Product;
import com.cs4.clothes.repository.ICategoryRepository;
import com.cs4.clothes.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(long id) {
    categoryRepository.deleteById(id);
    }

    @Override
    public Product findById(long id) {
        return null;
    }
}
