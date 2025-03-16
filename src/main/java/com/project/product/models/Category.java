package com.project.product.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel{
   @Column(unique = true)
   private String name;

   @OneToMany(fetch = jakarta.persistence.FetchType.EAGER, mappedBy = "category")
   private List<Product> products;
}
