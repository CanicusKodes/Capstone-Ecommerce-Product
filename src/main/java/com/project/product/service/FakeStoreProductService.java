package com.project.product.service;

import com.project.product.dtos.FakeStoreProductServiceDto;
import com.project.product.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    RestTemplateBuilder restTemplateBuilder;

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public String url = "https://fakestoreapi.com/products/1";
    @Override
    public String getAllProducts() {
        return "";
    }

    @Override
    public GenericProductDto getProductById(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductServiceDto> fakeStoreEntity = restTemplate.getForEntity(url, FakeStoreProductServiceDto.class);

        return convertToGeneric(fakeStoreEntity);
    }

    private GenericProductDto convertToGeneric(ResponseEntity<FakeStoreProductServiceDto> fakeStoreEntity) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreEntity.getBody().getId());
        genericProductDto.setTitle(fakeStoreEntity.getBody().getTitle());
        genericProductDto.setDescription(fakeStoreEntity.getBody().getDescription());
        genericProductDto.setPrice(fakeStoreEntity.getBody().getPrice());
        genericProductDto.setCategory(fakeStoreEntity.getBody().getCategory());
        genericProductDto.setImage(fakeStoreEntity.getBody().getImage());
        return genericProductDto;
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
