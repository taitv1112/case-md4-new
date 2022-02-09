package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.Product;
import com.cs4.clothes.repository.IProductRepository;
import com.cs4.clothes.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public Set<Product> findAll() {
        return (Set<Product>) productRepository.findAll();
    }

    @Override
    public Page<Product> findProductPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


    @Override
    public void save(Product product) {
    productRepository.save(product);
    }

    @Override
    public void delete(long id) {
    productRepository.deleteById(id);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Set<Product> findByName(String name) {
        return productRepository.findAllByName(name);
    }
}
