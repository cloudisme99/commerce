package com.example.commerce.member.service;

import com.example.commerce.admin.entity.Item;
import com.example.commerce.member.entity.Basket;
import com.example.commerce.member.entity.Member;
import com.example.commerce.member.repository.BasketRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    public void addBasket(Member member, Item item) {

//        Member member = memberRepository.getFirstByUserId(userId);
        //Member userId1 = memberRepository.getFirstByUserId(userId)

//        Optional<Member> optionalMember = memberRepository.findById(member.getI)


        Basket basket = new Basket();

        basket.setMember(member);
        basket.setItem(item);
        basket.setBasketRegisterDate(LocalDateTime.now());

        basketRepository.save(basket);
    }
}
