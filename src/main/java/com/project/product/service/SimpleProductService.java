package com.project.product.service;

import com.project.product.dtos.GenericProductDto;
import com.project.product.dtos.UserDto;
import com.project.product.inhertancerelations.tableperclass.User;
import com.project.product.models.Category;
import com.project.product.models.Price;
import com.project.product.models.Product;
import com.project.product.repositories.CategoryRepository;
import com.project.product.repositories.PriceRepository;
import com.project.product.repositories.ProductRepository;
import com.project.product.security.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Primary
@Service("SimpleProductService")
public class SimpleProductService implements ProductService {

    private final PriceRepository priceRepository;
    private final CategoryRepository categoryRepository;
    ProductRepository repository;

    RedisTemplate<UUID, Object> redisTemplate;

    RestTemplate restTemplate;

    @Autowired
    public SimpleProductService(ProductRepository repository, RedisTemplate<UUID, Object> redisTemplate, PriceRepository priceRepository, CategoryRepository categoryRepository, RestTemplate restTemplate) {
        this.repository = repository;
        this.redisTemplate = redisTemplate;
        this.priceRepository = priceRepository;
        this.categoryRepository = categoryRepository;
        this.restTemplate = restTemplate;
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
        ResponseEntity<UserDto> userEntity = restTemplate.getForEntity("http://Capstone-User-Service/users/1", UserDto.class);
        System.out.println(userEntity.getBody().getEmail());
        Set<Role> roles = userEntity.getBody().getRoles();
        for (Role role : roles) {
            System.out.println(role.getRole());
        }
        return cachedDto;
    }

    @Override
    public GenericProductDto addProduct(GenericProductDto generalProduct) {
        Product product = new Product();
        product.setPrice(new Price(generalProduct.getPrice()));
        product.setCategory(categoryRepository.findByName(generalProduct.getCategory()));
        product.setName(generalProduct.getTitle());
        product.setDescription(generalProduct.getDescription());
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
