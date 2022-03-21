package com.cs4.clothes.service;

import com.cs4.clothes.model.OrderDetail;
import com.cs4.clothes.model.OrderSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface IOrderDetailService {
    public List<OrderDetail> findAll();
    public Page<OrderDetail> findProductPage(Pageable pageable);
    public void save(OrderDetail orderDetail);
    public void delete(long id);
    public OrderDetail findById(long id);

}
