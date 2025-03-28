package com.project.product.repositories;

import com.project.product.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Override
    Product save(Product product);

    List<Product> findAllByNameAndDescription(String Name, String Description);

    List<Product> findAllByName(String query);

    List<Product> findAllByNameContaining(String query);

    List<Product> findAllByNameContaining(String query, Pageable pageable);

}
