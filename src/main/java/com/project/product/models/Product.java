package com.project.product.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{

    String ProductName;
    String ProductDescription;
    double ProductPrice;
    int ProductQuantity;
    String ProductCategory;
    String ProductImage;



}
