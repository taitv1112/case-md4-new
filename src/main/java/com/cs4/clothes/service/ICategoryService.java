package com.cs4.clothes.service;

import com.cs4.clothes.model.Category;
import com.cs4.clothes.model.Product;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();
    public void save(Category category);
    public void delete(long id);
    public Product findById(long id);
}
