package com.cs4.clothes.service;

import com.cs4.clothes.model.CartDetail;

import java.util.List;

public interface ICartDetailService {
    public List<CartDetail> findAll();
    public List<CartDetail> findCartDetailsByCart_Id(Long id);
    void delete(CartDetail cartDetail);
    void save(CartDetail cartDetail);

}
