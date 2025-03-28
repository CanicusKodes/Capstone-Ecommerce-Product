package com.project.product.controllers;


import com.project.product.dtos.GenericProductDto;
import com.project.product.service.ProductService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    //@Autowired OPTIONAL
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    GenericProductDto getProductById(@PathVariable("id") UUID id){
        return productService.getProductById(null,id);
    }
//
//    @GetMapping("/{id}")
//    GenericProductDto getProductById(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("id") long id){
//        return productService.getProductById(token,id);
//    }

    @PostMapping
    GenericProductDto addProduct(@RequestBody GenericProductDto product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    GenericProductDto updateProduct(@PathVariable("id") UUID id,@RequestBody GenericProductDto product){
       return productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    GenericProductDto deleteProduct(@PathVariable("id") UUID id){
       return productService.deleteProduct(id);
    }

//
//    @ExceptionHandler(ProductNotFoundException.class)
//    ResponseEntity handleProductNotFoundException(ProductNotFoundException e){
//        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND,e.getMessage()),HttpStatus.NOT_FOUND);
//    }


}
