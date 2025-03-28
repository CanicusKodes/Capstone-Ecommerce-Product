//package com.project.product.repositories;
//
//import com.project.product.models.Product;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository
//public interface OpenSearchProductRepository extends JpaRepository<Product, Long> {
//
//    List<Product> findAllByNameContaining(String query, Pageable pageable);
//
//    List<Product> getProductById(UUID id);
//
//    Optional<Product> getById(UUID id);
//}
