package com.project.product.service;


import com.project.product.dtos.GenericProductDto;
import com.project.product.dtos.SearchRequestDto;
import com.project.product.models.Product;
//import com.project.product.repositories.OpenSearchProductRepository;
import com.project.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ProductRepository productRepository;
//
//    @Autowired
//    private OpenSearchProductRepository openSearchProductRepository;

//    public List<GenericProductDto> searchProducts(String query) {
//        List<Product> products = productRepository.findAllByNameContaining(query);
//        List<GenericProductDto> genericProductDtos = new ArrayList<>();
//        for (Product product : products) {
//            genericProductDtos.add(product.toGenericProductDto(product));
//        }
//        return genericProductDtos;
//    }

    public List<GenericProductDto> searchProducts(String query, String pageNumber, String itemsPerPage) {
        Sort sort = Sort.by(Sort.Direction.DESC, "inventory_count");
        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(itemsPerPage), sort);
//        List<Product> products = productRepository.findAllByNameContaining(query,pageable);
        List<Product> products = productRepository.findAllByNameContaining(query,pageable);
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (Product product : products) {
            genericProductDtos.add(product.toGenericProductDto(product));
        }
        return genericProductDtos;
    }
}
