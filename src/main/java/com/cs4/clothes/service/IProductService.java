package com.cs4.clothes.service;

import com.cs4.clothes.model.Product;
import com.cs4.clothes.model.querry.ICartDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IProductService {
    public List<Product> findProductsByCategory_Name(String category_name);
    public List<Product> findAll();
    public Page<Product> findProductPage(Pageable pageable);
    public void save(Product product);
    public void delete(long id);
    public Product findById(long id);
    List<Product> findProductsByCategory_Id(Long id);
    List<Product> findProductsByNameContainingOrCategory_Name(String name);
    List<Product> findAllByName(String name);
    List<Product> findByCart(Long idCart);
}
