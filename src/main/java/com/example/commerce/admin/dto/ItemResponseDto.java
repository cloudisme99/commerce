package com.example.commerce.admin.dto;

import com.example.commerce.admin.entity.Item;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ItemResponseDto {

    private Long itemId;
    private int categoryId;
    private String itemName;
    private String itemInfo;
    private String itemImage;
    private String itemPrice;
    private int itemAmount;
    private LocalDateTime itemRegisterDate;
    private LocalDateTime itemUpdateDate;

    public ItemResponseDto(Item item) {
        this.itemId = item.getItemId();
        this.categoryId = item.getCategory().getCategoryId();
        this.itemName = item.getItemName();
        this.itemInfo = item.getItemInfo();
        this.itemImage = item.getItemImage();
        this.itemPrice = item.getItemPrice();
        this.itemAmount = item.getItemAmount();
        this.itemRegisterDate = item.getItemRegisterDate();
        this.itemUpdateDate = item.getItemUpdateDate();
    }
}
