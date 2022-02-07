package com.cs4.clothes.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class OrderSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalBill;
    private Date createAt;
    private Date modifyAt;
}
