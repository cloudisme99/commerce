package com.example.commerce.admin.repository;

import com.example.commerce.admin.entity.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Category findByCategoryName(String categoryName);

    Optional<Category> findByCategoryId(int categoryId);

}
