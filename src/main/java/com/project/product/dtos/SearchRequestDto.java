package com.project.product.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {

    private String query;
    private String pageNumber;
    private String itemsPerPage;

}
