package com.example.commerce.admin.repository;

import com.example.commerce.admin.entity.Category;
import com.example.commerce.member.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Category findByCategoryName(String categoryName);
}
