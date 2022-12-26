package com.example.commerce.member.controller;

import com.example.commerce.member.dto.BasketRequestDto;
import com.example.commerce.member.entity.Basket;
import com.example.commerce.member.repository.BasketRepository;
import com.example.commerce.member.service.BasketService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BasketController {

    private final BasketRepository basketRepository;

    private final BasketService basketService;

    // basket 저장
    @PostMapping("/basket/add/")
    public ResponseEntity addBasket(@RequestParam Long userId, Long itemId, @RequestBody BasketRequestDto dto) {
        return ResponseEntity.ok(basketService.addBasket(userId, itemId, dto));
    }

    // basket 조회
    @GetMapping("/basket/list")
    List<Basket> readBasket(@RequestParam Long userId) {
        return basketService.readBasket(userId);
    }

    // basket 삭제
    @DeleteMapping("/basket/list/delete")
    public void deleteBasket(@RequestParam Long userId, Long itemId) {
        basketService.deleteBasket(userId, itemId);
    }

    // basket 등록 기간별 조회
    @GetMapping("/basket/dateList")
    List<Basket> readBasketsDate(@RequestParam Long userId,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return basketService.readBasketsDate(userId, startDate, endDate);
    }
}
