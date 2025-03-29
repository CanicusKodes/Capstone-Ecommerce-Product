package com.project.product.models;


import com.project.product.dtos.GenericProductDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
//import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Entity
//@Document(indexName = "products")
public class Product extends BaseModel implements Serializable {

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

    private int inventoryCount;

    public GenericProductDto toGenericProductDto(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(product.getName());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setCategory(product.getCategory().getName());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setPrice(product.getPrice().getValue());
        genericProductDto.setId(product.getId());
        return genericProductDto;
    }



}
