package com.example.commerce.admin.service;

import com.example.commerce.admin.entity.Category;
import com.example.commerce.admin.entity.Item;
import com.example.commerce.admin.repository.ItemRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminItemService {

    private final ItemRepository itemRepository;

    public List<Item> readItems() {
        List<Item> items = itemRepository.findAll();
        if(!items.isEmpty()) return itemRepository.findAll();
        else throw new IllegalArgumentException("등록된 상품이 없습니다.");
    }

    public void addItem(Category category, String itemName, String itemInfo, String itemImage, String itemPrice, int itemAmount) {

        Item item = new Item();
        item.setCategory(category);
        item.setItemName(itemName);
        item.setItemInfo(itemInfo);
        item.setItemImage(itemImage);
        item.setItemPrice(itemPrice);
        item.setItemAmount(itemAmount);
        item.setItemRegisterDate(LocalDateTime.now());

        itemRepository.save(item);

    }

    // item 삭제
    @Transactional
    public void deleteItem(String itemName) {

        Item item = itemRepository.findByItemName(itemName);

        itemRepository.delete(item);
    }

    // item 검색
    @Transactional
    public List<Item> search(String keyword) {
        List<Item> itemList = itemRepository.findByItemNameContaining(keyword);
        return itemList;
    }
}
