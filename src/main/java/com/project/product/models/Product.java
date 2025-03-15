package com.project.product.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String ProductName;

    private String ProductDescription;

    @OneToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(nullable = false, unique = true)
    private Price ProductPrice;

    private int ProductQuantity;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category ProductCategory;

    private String ProductImage;




}
