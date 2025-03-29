package com.project.product.models;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
public class Price extends BaseModel implements Serializable {

    private String Currency;
    private Double Value;

    public Price(double price) {
        super();
    }

    public Price() {

    }
}
