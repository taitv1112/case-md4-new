package com.cs4.clothes.repository;

import com.cs4.clothes.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICartRepo extends JpaRepository<Cart, Long> {

}
