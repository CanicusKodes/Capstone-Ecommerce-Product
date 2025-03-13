package com.project.product.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductServiceDto {

    private long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;

}
