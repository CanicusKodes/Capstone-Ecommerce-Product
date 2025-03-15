package com.project.product.thirdPartyClients.fakeStoreClient;

import com.project.product.dtos.FakeStoreProductServiceDto;
import com.project.product.dtos.GenericProductDto;
import com.project.product.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreAdapterClient {


    RestTemplateBuilder restTemplateBuilder;

    FakeStoreAdapterClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Value("${spring.url.fakeStore.specificProduct}")
    public String singleProduct;

    @Value("${spring.url.fakeStore.product}")
    public String products;


    public List<FakeStoreProductServiceDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductServiceDto[]> fakeStoreEntity = restTemplate.getForEntity(products, FakeStoreProductServiceDto[].class);
        return List.of(fakeStoreEntity.getBody());
    }


    public FakeStoreProductServiceDto getProductById(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductServiceDto> fakeStoreEntity = restTemplate.getForEntity(singleProduct, FakeStoreProductServiceDto.class,id);
        if(fakeStoreEntity.getBody() == null){
            throw new ProductNotFoundException("Product not found with id: "+id);
        }
        return fakeStoreEntity.getBody();
    }




    public FakeStoreProductServiceDto addProduct(GenericProductDto genericProduct) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductServiceDto> fakeStoreEntity = restTemplate.postForEntity(products, genericProduct, FakeStoreProductServiceDto.class);
        return fakeStoreEntity.getBody();
    }


    public FakeStoreProductServiceDto updateProduct(Long id,GenericProductDto genericProduct) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductServiceDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductServiceDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductServiceDto.class);
        ResponseEntity<FakeStoreProductServiceDto> fakestoreupdate = restTemplate.execute(singleProduct, HttpMethod.PUT, requestCallback, responseExtractor, id);
        return fakestoreupdate.getBody();
    }


    public FakeStoreProductServiceDto deleteProduct(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductServiceDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductServiceDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductServiceDto.class);
        ResponseEntity<FakeStoreProductServiceDto> fakestoredel = restTemplate.execute(singleProduct, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return fakestoredel.getBody();
    }


}
