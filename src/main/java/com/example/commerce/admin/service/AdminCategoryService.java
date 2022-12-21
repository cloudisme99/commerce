package com.example.commerce.admin.service;

import com.example.commerce.admin.entity.Category;
import com.example.commerce.admin.repository.CategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminCategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> readCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(!categories.isEmpty()) return categoryRepository.findAll();
        else throw new IllegalArgumentException("카테고리가 없습니다.");
    }

    public void addCategory(String categoryName) {

        Category category = new Category();

        category.setCategoryName(categoryName);
        category.setUsingYn(true);

        categoryRepository.save(category);

    }

    @Transactional
    public void deleteCategory(String categoryName) {
        //List<Category> deleteCategory = categoryRepository.deleteByCategoryName(categoryName);

        Category category = categoryRepository.findByCategoryName(categoryName);

        categoryRepository.delete(category);
    }

}
