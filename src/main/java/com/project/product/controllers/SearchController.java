package com.project.product.controllers;


import com.project.product.dtos.GenericProductDto;
import com.project.product.dtos.SearchRequestDto;
import com.project.product.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/search")
public class SearchController {


    private final SearchService searchService;

    @PostMapping
    public List<GenericProductDto> searchProductsSimple(@RequestBody SearchRequestDto searchRequestDto) {
        return searchService.searchProducts(searchRequestDto.getQuery(),searchRequestDto.getPageNumber(),searchRequestDto.getItemsPerPage());
    }

    @PostMapping("/")
    public Page<GenericProductDto> searchProducts(@RequestBody SearchRequestDto searchRequestDto) {
        List<GenericProductDto> genericProductDtos = searchService.searchProducts(searchRequestDto.getQuery(),searchRequestDto.getPageNumber(),searchRequestDto.getItemsPerPage());
        return new PageImpl<>(genericProductDtos);
    }

}
