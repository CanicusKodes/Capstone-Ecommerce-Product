package com.project.product.service;

import com.project.product.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {

    List<GenericProductDto> getAllProducts();
    GenericProductDto getProductById(long id);
    GenericProductDto addProduct(GenericProductDto product);
    void updateProduct();
    void deleteProduct();

}
