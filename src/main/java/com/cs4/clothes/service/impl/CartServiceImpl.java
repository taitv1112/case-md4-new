package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.Cart;
import com.cs4.clothes.repository.ICartDetailRepository;
import com.cs4.clothes.repository.ICartRepo;
import com.cs4.clothes.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    ICartRepo iCartRepo;
    @Autowired
    ICartDetailRepository cartDetailRepo;
    @Override
    public void save(Cart cart) {
        iCartRepo.save(cart);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Cart> findAll() {
        return null;
    }
}
