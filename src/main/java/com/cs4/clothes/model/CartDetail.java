package com.cs4.clothes.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double quantity;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    Product product;
}
