package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.OrderDetail;
import com.cs4.clothes.repository.IOrderDetail;
import com.cs4.clothes.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailImpl implements IOrderDetailService {
    @Autowired
    IOrderDetail iOrderDetail;
    @Override
    public List<OrderDetail> findAll() {
        return null;
    }

    @Override
    public Page<OrderDetail> findProductPage(Pageable pageable) {
        return null;
    }

    @Override
    public void save(OrderDetail orderDetail) {
        iOrderDetail.save(orderDetail);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public OrderDetail findById(long id) {
        return null;
    }
}
