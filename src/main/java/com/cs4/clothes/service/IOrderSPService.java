package com.cs4.clothes.service;

import com.cs4.clothes.model.OrderSP;
import com.cs4.clothes.model.querry.IOrders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IOrderSPService {
    public List<OrderSP> findAll();
    public Page<OrderSP> findProductPage(Pageable pageable);
    public void save(OrderSP orderSP);
    public void delete(long id);
    public OrderSP findById(long id);
    public Set<OrderSP> findByName (String name);
    List<IOrders> showOrders (String userName);

    List<OrderSP> findByUsername(Long id);
}
