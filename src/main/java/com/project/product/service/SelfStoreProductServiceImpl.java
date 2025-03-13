package com.project.product.service;


import com.project.product.dtos.FakeStoreProductServiceDto;
import com.project.product.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

@Service("selfStoreProductService")
public class SelfStoreProductServiceImpl implements ProductService {
    @Override
    public String getAllProducts() {
        return "";
    }

    @Override
    public GenericProductDto getProductById(long id) {
        return null;
    }

    @Override
    public void addProduct() {

    }

    @Override
    public void updateProduct() {

    }

    @Override
    public void deleteProduct() {

    }
}
