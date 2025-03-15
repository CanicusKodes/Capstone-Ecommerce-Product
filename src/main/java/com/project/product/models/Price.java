package com.project.product.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Price extends BaseModel{

    private String Currency;
    private Double Value;
}
