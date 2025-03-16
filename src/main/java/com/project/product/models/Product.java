package com.project.product.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{


    private String name;


    private String description;

    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST}, optional = false)
    @JoinColumn(nullable = false, unique = true)
    private Price price;

    private int quantity;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;

    @Column
    private String image;



}
