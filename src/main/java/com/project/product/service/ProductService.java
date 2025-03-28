package com.project.product.service;

import com.project.product.dtos.GenericProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<GenericProductDto> getAllProducts();
    GenericProductDto getProductById(String token, UUID id);
    GenericProductDto addProduct(GenericProductDto product);
    GenericProductDto updateProduct(UUID id,GenericProductDto product);
    GenericProductDto deleteProduct(UUID id);

}
