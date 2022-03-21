package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.OrderSP;
import com.cs4.clothes.model.querry.IOrders;
import com.cs4.clothes.repository.IOrderSP;
import com.cs4.clothes.service.IOrderSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class OrderSPServiceImpl implements IOrderSPService {
    @Autowired
    IOrderSP iOrderSP;
    @Override
    public List<OrderSP> findAll() {
        return null;
    }

    @Override
    public Page<OrderSP> findProductPage(Pageable pageable) {
        return null;
    }

    @Override
    public void save(OrderSP orderSP) {
        iOrderSP.save(orderSP);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public OrderSP findById(long id) {
        return null;
    }

    @Override
    public Set<OrderSP> findByName(String name) {
        return null;
    }

    @Override
    public List<IOrders> showOrders(String userName) {
        return iOrderSP.showOrders(userName);
    }

    @Override
    public List<OrderSP> findByUsername(Long id) {
        return iOrderSP.findByUsername( id);
    }

}
