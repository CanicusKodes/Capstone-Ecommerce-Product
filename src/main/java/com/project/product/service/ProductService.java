package com.project.product.service;

import com.project.product.dtos.FakeStoreProductServiceDto;
import com.project.product.dtos.GenericProductDto;

public interface ProductService {

    String getAllProducts();
    GenericProductDto getProductById(long id);
    void addProduct();
    void updateProduct();
    void deleteProduct();

}
