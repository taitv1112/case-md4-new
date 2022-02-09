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
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public Set<Product> findAll() {
        return (Set<Product>) iProductRepository.findAll();
    }

    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public void delete(long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Product findByID(long id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public Set<Product> findByName(String name) {
        return iProductRepository.findAllByName(name);
    }
}
