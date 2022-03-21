package com.cs4.clothes.repository;


import com.cs4.clothes.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderDetail extends JpaRepository<OrderDetail, Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM case4xxx.order_detail where order_detail.order_id = :id")
    List<OrderDetail> findByIdOrderSP (Long id);
}
