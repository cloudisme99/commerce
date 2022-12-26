package com.example.commerce.admin.repository;

import com.example.commerce.admin.entity.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    Item findByItemName(String itemName);

    List<Item> findByItemNameContaining(String keyword);

    Optional<Item> findByItemId(Long itemId);
}
