package com.example.commerce.admin.dto;

import com.example.commerce.admin.entity.Category;
import lombok.Getter;

@Getter
public class CategoryResponseDto {
    private int categoryId;

    public CategoryResponseDto(Category category) {
        this.categoryId = category.getCategoryId();
    }
}
