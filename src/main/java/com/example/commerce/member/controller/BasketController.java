package com.example.commerce.member.controller;

import com.example.commerce.member.entity.Basket;
import com.example.commerce.member.service.BasketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BasketController {

    private final BasketService basketService;

    @PostMapping("/basket/add")
    public void addBasket(@RequestBody Basket request) {
        basketService.addBasket(
            request.getMember(),
            request.getItem()
        );
    }
}
