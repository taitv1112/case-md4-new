package com.cs4.clothes.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class OrderSP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double totalBill;
    private Date createAt;
    private Date modifyAt;
    private String status;
    public OrderSP( double totalBill, Date createAt, Date modifyAt, Users users) {
        this.totalBill = totalBill;
        this.createAt = createAt;
        this.modifyAt = modifyAt;
        this.users = users;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    Users users;

    public OrderSP() {

    }
}
