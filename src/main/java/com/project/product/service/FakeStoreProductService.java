package com.project.product.service;

import com.project.product.dtos.FakeStoreProductServiceDto;
import com.project.product.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    RestTemplateBuilder restTemplateBuilder;

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public String singleProduct = "https://fakestoreapi.com/products/{id}";
    public String products = "https://fakestoreapi.com/products";

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductServiceDto[]> fakeStoreEntity = restTemplate.getForEntity(products, FakeStoreProductServiceDto[].class);
        List<GenericProductDto> result = new ArrayList<>();
        List<FakeStoreProductServiceDto> fakeStoreProductServiceDtos = List.of(fakeStoreEntity.getBody());
        for (FakeStoreProductServiceDto fakeStoreProductServiceDto : fakeStoreProductServiceDtos) {
            result.add(convertToGeneric(fakeStoreProductServiceDto));
        }
        return result;
    }

    @Override
    public GenericProductDto getProductById(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductServiceDto> fakeStoreEntity = restTemplate.getForEntity(singleProduct, FakeStoreProductServiceDto.class,id);

        return convertToGeneric(fakeStoreEntity.getBody());
    }



    @Override
    public GenericProductDto addProduct(GenericProductDto genericProduct) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductServiceDto> fakeStoreEntity = restTemplate.postForEntity(products, genericProduct, FakeStoreProductServiceDto.class);
        return convertToGeneric(fakeStoreEntity.getBody());
    }

    @Override
    public void updateProduct() {

    }

    @Override
    public void deleteProduct() {

    }

    private GenericProductDto convertToGeneric(FakeStoreProductServiceDto fakeStoreEntity) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreEntity.getId());
        genericProductDto.setTitle(fakeStoreEntity.getTitle());
        genericProductDto.setDescription(fakeStoreEntity.getDescription());
        genericProductDto.setPrice(fakeStoreEntity.getPrice());
        genericProductDto.setCategory(fakeStoreEntity.getCategory());
        genericProductDto.setImage(fakeStoreEntity.getImage());
        return genericProductDto;
    }
}
