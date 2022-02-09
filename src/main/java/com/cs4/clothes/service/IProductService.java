package com.cs4.clothes.service;

import com.cs4.clothes.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface IProductService {
    Set<Product> findAll();
    Page<Product> findAllProduct(Pageable pageable);
    Product save(Product product);
    void delete(long id);
    Product findByID(long id);
    Set<Product> findByName(String name);

}
