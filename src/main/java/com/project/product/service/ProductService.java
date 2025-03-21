package com.project.product.service;

import com.project.product.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {

    List<GenericProductDto> getAllProducts();
    GenericProductDto getProductById(String token,long id);
    GenericProductDto addProduct(GenericProductDto product);
    GenericProductDto updateProduct(Long id,GenericProductDto product);
    GenericProductDto deleteProduct(long id);

}
