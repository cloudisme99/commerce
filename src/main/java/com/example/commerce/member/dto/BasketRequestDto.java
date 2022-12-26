package com.example.commerce.member.dto;

import com.example.commerce.admin.entity.Item;
import com.example.commerce.member.entity.Basket;
import com.example.commerce.member.entity.Member;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketRequestDto {
    private int basketId;
    private Member member;
    private Item item;
    private LocalDateTime basketRegisterDate;
    private LocalDateTime basketUpdateDate;

    // Dto -> Entity
    public Basket addBasket() {
        Basket addBasket = Basket.builder()
            .basketId(basketId)
            .member(member)
            .item(item)
            .basketRegisterDate(LocalDate.now())
            .build();
        return addBasket;
    }
}
