package com.project.product.controllers;


import com.project.product.dtos.FakeStoreProductServiceDto;
import com.project.product.dtos.GenericProductDto;
import com.project.product.service.FakeStoreProductService;
import com.project.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //@Autowired OPTIONAL
    private ProductService productService;

    ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    GenericProductDto getProductById(@PathVariable("id") long id){
        return productService.getProductById(id);
    }

    @PostMapping
    GenericProductDto addProduct(@RequestBody GenericProductDto product){
        return productService.addProduct(product);
    }

    void updateProduct(){

    }

    void deleteProduct(){

    }


}
