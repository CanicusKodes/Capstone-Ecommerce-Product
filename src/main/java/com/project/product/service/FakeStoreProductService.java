package com.project.product.service;

import com.project.product.dtos.FakeStoreProductServiceDto;
import com.project.product.dtos.GenericProductDto;
import com.project.product.exceptions.ProductNotFoundException;
import com.project.product.security.JWTObject;
import com.project.product.security.TokenValidator;
import com.project.product.thirdPartyClients.fakeStoreClient.FakeStoreAdapterClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    FakeStoreAdapterClient fakeStoreClient;

    TokenValidator tokenValidator;

    FakeStoreProductService(TokenValidator tokenValidator,FakeStoreAdapterClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
        this.tokenValidator = tokenValidator;
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

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> result = new ArrayList<>();
        List<FakeStoreProductServiceDto> fakeStoreProductServiceDtos = fakeStoreClient.getAllProducts();
        for (FakeStoreProductServiceDto fakeStoreProductServiceDto : fakeStoreProductServiceDtos) {
            result.add(convertToGeneric(fakeStoreProductServiceDto));
        }
        return result;
    }

    @Override
    public GenericProductDto getProductById(String token,long id) {
        Optional<JWTObject> jwtObject = tokenValidator.validate(token);
        return convertToGeneric(fakeStoreClient.getProductById(id));
    }



    @Override
    public GenericProductDto addProduct(GenericProductDto genericProduct) {
        return convertToGeneric(fakeStoreClient.addProduct(genericProduct));
    }

    @Override
    public GenericProductDto updateProduct(Long id,GenericProductDto genericProduct) {

        return convertToGeneric(fakeStoreClient.updateProduct(id,genericProduct));
    }

    @Override
    public GenericProductDto deleteProduct(long id) {
        return convertToGeneric(fakeStoreClient.deleteProduct(id));
    }


}
