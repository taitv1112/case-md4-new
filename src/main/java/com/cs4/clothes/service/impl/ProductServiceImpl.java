package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.Product;
import com.cs4.clothes.repository.ICartDetailRepository;
import com.cs4.clothes.repository.IProductRepository;
import com.cs4.clothes.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ICartDetailRepository iCartDetailRepo;
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findProductsByCategory_Name(String category_name) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
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
    public List<Product> findProductsByCategory_Id(Long id) {
        return productRepository.findProductsByCategory_Id(id);
    }

    @Override
    public List<Product> findProductsByNameContainingOrCategory_Name(String name) {
        return productRepository.findProductsByNameContaining(name);
    }

    @Override
    public List<Product> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public List<Product> findByCart(Long idCart) {
        return productRepository.findByCart(idCart);
    }

}
