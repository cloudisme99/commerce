package com.example.commerce.admin.service;

import com.example.commerce.admin.dto.ItemRequestDto;
import com.example.commerce.admin.entity.Category;
import com.example.commerce.admin.entity.Item;
import com.example.commerce.admin.repository.CategoryRepository;
import com.example.commerce.admin.repository.ItemRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public List<Item> readItems() {
        List<Item> items = itemRepository.findAll();
        if(!items.isEmpty()) {
            return items;
        } else throw new IllegalArgumentException("등록된 상품이 없습니다.");
    }

    @Transactional
    public int addItem(int categoryId, ItemRequestDto dto) {
        Optional<Category> category = categoryRepository.findByCategoryId(categoryId);
        dto.setCategory(category.get());

        Item item = dto.toEntity();

        itemRepository.save(item);

        return dto.getCategory().getCategoryId();
    }

    @Transactional
    public void deleteItem(String itemName) {

        Item item = itemRepository.findByItemName(itemName);

        itemRepository.delete(item);
    }

    @Transactional
    public List<Item> itemSearch(String keyword) {
        List<Item> itemList = itemRepository.findByItemNameContaining(keyword);
        return itemList;
    }
}
