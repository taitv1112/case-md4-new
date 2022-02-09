package com.cs4.clothes.service;

import com.cs4.clothes.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface IProductService {
    public List<Product> findAll();
    public Page<Product> findProductPage(Pageable pageable);
    public void save(Product product);
    public void delete(long id);
    public Product findById(long id);
    public Set<Product> findByName (String name);
}
