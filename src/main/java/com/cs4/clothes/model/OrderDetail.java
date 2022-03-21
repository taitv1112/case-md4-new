package com.cs4.clothes.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantity;

    @ManyToOne
    private OrderSP order;

    @ManyToOne
    Product product;

    public OrderDetail( double quantity, OrderSP order, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    public OrderDetail() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDetail that = (OrderDetail) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
