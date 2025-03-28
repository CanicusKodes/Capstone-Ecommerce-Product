package com.project.product.service;

import com.project.product.dtos.GenericProductDto;
import com.project.product.models.Product;
import com.project.product.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Primary
@Service("SimpleProductService")
public class SimpleProductService implements ProductService {

    ProductRepository repository;

    RedisTemplate<UUID, Object> redisTemplate;

    @Autowired
    public SimpleProductService(ProductRepository repository,RedisTemplate<UUID, Object> redisTemplate) {
        this.repository = repository;
        this.redisTemplate = redisTemplate;
    }

//    @Autowired
//    OpenSearchProductRepository repositoryOpenSearch;

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = repository.findAll();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (Product product : products) {
            genericProductDtos.add(product.toGenericProductDto(product));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto getProductById(String token, UUID id) {
        GenericProductDto cachedDto = (GenericProductDto) redisTemplate.opsForHash().get(id, "PRODUCTS");
        if(cachedDto == null) {
            // Get the product from database
            Product product = repository.findById(id).orElse(null);
            if (product != null) {
                // Convert to DTO
                cachedDto = product.toGenericProductDto(product);
                // Store DTO in cache
                redisTemplate.opsForHash().put(id, "PRODUCTS", cachedDto);
            }
        }
        return cachedDto;
    }

    @Override
    public GenericProductDto addProduct(GenericProductDto generalProduct) {
        Product product = new Product();
        product.setName(generalProduct.getTitle());
        product.setPrice(generalProduct.getPrice());
        product.setDescription(generalProduct.getDescription());
        product.setCategory(generalProduct.getCategory());
        Product savedProduct = repository.save(product);
//        repositoryOpenSearch.save(savedProduct);

        return null;
    }

    @Override
    public GenericProductDto updateProduct(UUID id, GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(UUID id) {
        return null;
    }
}
