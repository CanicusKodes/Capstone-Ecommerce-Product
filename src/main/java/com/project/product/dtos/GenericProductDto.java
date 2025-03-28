package com.project.product.dtos;

import com.project.product.models.Category;
import com.project.product.models.Price;
import com.project.product.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class GenericProductDto  implements Serializable {

    private UUID id;
    private String title;
    private String description;
    private Price price;
    private Category category;
    private String image;


}
