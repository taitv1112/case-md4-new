package com.cs4.clothes.model;

import com.cs4.clothes.model.querry.SizeName;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Data
public class Sizes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private SizeName name;
}
