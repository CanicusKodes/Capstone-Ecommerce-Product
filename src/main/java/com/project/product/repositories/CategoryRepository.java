package com.project.product.repositories;

import com.project.product.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Override
    Category save(Category category);


    Category findByName(String name);
}
