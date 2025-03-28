package com.project.product.models;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Price extends BaseModel implements Serializable {

    private String Currency;
    private Double Value;

    public Price(double price) {
        super();
    }
}
