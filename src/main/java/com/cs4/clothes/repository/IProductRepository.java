package com.cs4.clothes.repository;

import com.cs4.clothes.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select u from Product u where u.name like concat('%' ,:name, '%')")
    Set<Product> findAllByName(@Param("name") String name);

}
