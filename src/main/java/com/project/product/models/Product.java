package com.project.product.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String ProductName;
    private String ProductDescription;
    private double ProductPrice;
    private int ProductQuantity;

    @ManyToOne
    private Category ProductCategory;
    private String ProductImage;



}
