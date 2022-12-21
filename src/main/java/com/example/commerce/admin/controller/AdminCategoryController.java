package com.example.commerce.admin.controller;

import com.example.commerce.admin.entity.Category;
import com.example.commerce.admin.service.AdminCategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdminCategoryController {

    private final AdminCategoryService adminCategoryService;

    @GetMapping("/category")
    List<Category> readCategories() {
        return adminCategoryService.readCategories();
    }

    // 카테고리 등록
    @PostMapping("/admin/category/add")
    public void addCategory(@RequestBody Category request) {
        adminCategoryService.addCategory(request.getCategoryName());
    }

    // 카테고리 삭제
    @DeleteMapping("/admin/category/delete")
    public void deleteCategory(@RequestBody Category request) {
        adminCategoryService.deleteCategory(request.getCategoryName());
    }

}
