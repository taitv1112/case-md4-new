package com.cs4.clothes.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double quantity;
    private double quantity_sale;
    private double quantity_max;
    private double quantity_min;
    private String img;
    private String description;
    private double view;
    private String status;
    @ManyToOne
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_size", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "size_id"))
    Set<Sizes> sizes = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
