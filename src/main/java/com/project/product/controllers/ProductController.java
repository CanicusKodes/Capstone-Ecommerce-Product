package com.project.product.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {


    @GetMapping
    String getAllProducts(){
        return "All Products";
    }

    @GetMapping("/{id}")
    String getProductById(@PathVariable("id") long id){
        return "Product with id: " + id;
    }

    void addProduct(){

    }

    void updateProduct(){

    }

    void deleteProduct(){

    }


}
