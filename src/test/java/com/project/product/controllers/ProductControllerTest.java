package com.project.product.controllers;

import com.project.product.service.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Inject
    private MockMvc mockMvc;

    @MockitoBean
    ProductService productService;

//    @Inject
//    ProductController productController;
//
//    @Test
//    void testGetProductById(){
//        when(productService.getProductById(1000)).thenReturn(null);
//        assertEquals(productService.getProductById(1000), null);
//    }
//
//    @Test
//    void testGetProductByUdMockException(){
//        when(productService.getProductById(1000)).thenThrow(ProductNotFoundException.class);
//
//        assertThrows(ProductNotFoundException.class,() -> productService.getProductById(1000));
//    }

    @Test
    void testGetALlProductController() throws Exception {
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());


        mockMvc.perform(get("/products")).andExpect(status().isOk()).andExpect(content().string("[]"));

    }
}
