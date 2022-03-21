package com.cs4.clothes.repository;


import com.cs4.clothes.model.OrderSP;
import com.cs4.clothes.model.querry.IOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderSP extends JpaRepository<OrderSP, Long> {
    @Query(nativeQuery = true, value = "SELECT users.name as nameU , users.phone as phone , product.name as nameP ,product.img as img, order_detail.quantity as quantity , orderSp.total_bill as bill, ordersp.id as idOrdersp, ordersp.status as orderStatus FROM case4xxx.ordersp "
            + "join users on user_id = users.id" +
            " join order_detail on ordersp.id = order_detail.order_id" +
            " join product on order_detail.product_id = product.id " +
            "where username = :userName")
    List<IOrders> showOrders (@Param("userName") String userName);
    @Query(value = "select o from OrderSP o where o.users.id =:id  order by o.id desc")
    List<OrderSP> findByUsername(@Param("id") Long id);

}
