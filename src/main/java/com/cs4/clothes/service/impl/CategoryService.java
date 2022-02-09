package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.Category;
import com.cs4.clothes.repository.ICategoryRepo;
import com.cs4.clothes.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;

    @Override
    public List<Category> findAll() {
        return iCategoryRepo.findAll();
    }
}
