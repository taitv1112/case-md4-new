package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.CartDetail;
import com.cs4.clothes.repository.ICartDetailRepository;
import com.cs4.clothes.service.ICartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartDetailImpl implements ICartDetailService {
    @Autowired
    ICartDetailRepository iCartDetailRepository;
    @Override
    public List<CartDetail> findAll() {
        return iCartDetailRepository.findAll();
    }

    @Override
    public List<CartDetail> findCartDetailsByCart_Id(Long id) {
        return iCartDetailRepository.findCartDetailsByCart_Id(id);
    }

    @Override
    public void delete(CartDetail cartDetail) {
        iCartDetailRepository.delete(cartDetail);
    }

    @Override
    public void save(CartDetail cartDetail) {
        iCartDetailRepository.save(cartDetail);
    }
}
