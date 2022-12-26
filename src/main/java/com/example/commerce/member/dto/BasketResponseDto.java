package com.example.commerce.member.dto;

import com.example.commerce.member.entity.Basket;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class BasketResponseDto {

    private int basketId;
    private Long userId;
    private Long itemId;
    private LocalDate basketRegisterDate;
    private LocalDate basketUpdateDate;

    public BasketResponseDto(Basket basket) {
        this.basketId = basket.getBasketId();
        this.userId = basket.getMember().getUserId();
        this.itemId = basket.getItem().getItemId();
        this.basketRegisterDate = basket.getBasketRegisterDate();
    }

}
