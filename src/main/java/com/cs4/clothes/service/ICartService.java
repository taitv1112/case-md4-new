package com.cs4.clothes.service;

import com.cs4.clothes.model.Cart;
import com.cs4.clothes.model.OrderSP;

import java.util.List;
import java.util.Set;

public interface ICartService {
    public void save(Cart cart);
    public void delete(long id);
    public List<Cart> findAll();

}
