package com.example.commerce.admin.dto;

import com.example.commerce.admin.entity.Category;
import com.example.commerce.admin.entity.Item;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemRequestDto {

    private Long itemId;
    private Category category;
    private String itemName;
    private String itemInfo;
    private String itemImage;
    private String itemPrice;
    private int itemAmount;
    private LocalDateTime itemRegisterDate;
    private LocalDateTime itemUpdateDate;

    // Dto -> Entity
    public Item toEntity() {
        Item items = Item.builder()
            .itemId(itemId)
            .category(category)
            .itemName(itemName)
            .itemInfo(itemInfo)
            .itemImage(itemImage)
            .itemPrice(itemPrice)
            .itemAmount(itemAmount)
            .itemRegisterDate(LocalDateTime.now())
            .itemUpdateDate(LocalDateTime.now())
            .build();
        return items;
    }
}
