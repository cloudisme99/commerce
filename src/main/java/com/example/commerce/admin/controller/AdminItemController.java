package com.example.commerce.admin.controller;

import com.example.commerce.admin.entity.Category;
import com.example.commerce.admin.entity.Item;
import com.example.commerce.admin.service.AdminItemService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdminItemController {

    private final AdminItemService adminItemService;

    // item 조회
    @GetMapping("/item")
    List<Item> readItems() {
        return adminItemService.readItems();
    }

    // item 추가
    @PostMapping("/admin/item/add")
    public void addItem(@RequestBody Item request) {

        adminItemService.addItem(
            request.getCategory(),
            request.getItemName(),
            request.getItemInfo(),
            request.getItemImage(),
            request.getItemPrice(),
            request.getItemAmount()
        );
    }

    // item 삭제
    @DeleteMapping("/admin/item/delete")
    public void deleteItem(@RequestBody Item request) {
        adminItemService.deleteItem(request.getItemName());
    }

    // item 검색
    @GetMapping("/item/search")
    List<Item> search(@RequestParam String keyword) {
        List<Item> itemList = adminItemService.search(keyword);

        return adminItemService.search(keyword);
    }
}
