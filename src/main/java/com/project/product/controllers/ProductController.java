package com.project.product.controllers;


import com.project.product.dtos.GenericProductDto;
import com.project.product.service.ProductService;
import com.sun.net.httpserver.HttpsServer;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    GenericProductDto getProductById(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("id") long id){
        return productService.getProductById(token,id);
    }

    @PostMapping
    GenericProductDto addProduct(@RequestBody GenericProductDto product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    GenericProductDto updateProduct(@PathVariable("id") long id,@RequestBody GenericProductDto product){
       return productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    GenericProductDto deleteProduct(@PathVariable("id") long id){
       return productService.deleteProduct(id);
    }

//
//    @ExceptionHandler(ProductNotFoundException.class)
//    ResponseEntity handleProductNotFoundException(ProductNotFoundException e){
//        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND,e.getMessage()),HttpStatus.NOT_FOUND);
//    }


}
