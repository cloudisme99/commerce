package com.example.commerce.member.service;

import com.example.commerce.admin.entity.Item;
import com.example.commerce.admin.repository.ItemRepository;
import com.example.commerce.member.dto.BasketRequestDto;
import com.example.commerce.member.entity.Basket;
import com.example.commerce.member.entity.Member;
import com.example.commerce.member.repository.BasketRepository;
import com.example.commerce.member.repository.MemberRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long addBasket(Long userId, Long itemId, BasketRequestDto dto) {
        Optional<Member> member = memberRepository.findByUserId(userId);
        if(!member.isPresent()) {
            throw new IllegalArgumentException("회원 정보가 없습니다.");
        }

        Optional<Item> item = itemRepository.findByItemId(itemId);
        if(!item.isPresent()) {
            throw new IllegalArgumentException("상품 정보가 없습니다.");
        }

        dto.setMember(member.get());
        dto.setItem(item.get());

        Basket basket = dto.addBasket();
        basketRepository.save(basket);

        return dto.getMember().getUserId();
    }

    public List<Basket> readBasket(Long userId) {
        Optional<Member> member = memberRepository.findByUserId(userId);
        if(!member.isPresent()) {
            throw new IllegalArgumentException("회원정보가 없습니다.");
        }

        List<Basket> basketList = basketRepository.findByMember_UserId(userId);
        if(!basketList.isEmpty()) return basketList;
        else throw new IllegalArgumentException("조회할 장바구니 목록이 없습니다.");
    }

    @Transactional
    public void deleteBasket(Long userId, Long itemId) {
        Optional<Member> member = memberRepository.findByUserId(userId);
        if(!member.isPresent()) {
            throw new IllegalArgumentException("회원정보가 없습니다.");
        }

        Optional<Item> item = itemRepository.findByItemId(itemId);
        if(!item.isPresent()) {
            throw new IllegalArgumentException("상품 정보가 없습니다.");
        }

        Basket basket = basketRepository.findBasketByMember_UserIdAndItem_ItemId(userId, itemId);
        basketRepository.delete(basket);

    }

    public List<Basket> readBasketsDate(Long userId, LocalDate startDate, LocalDate endDate) {
        Optional<Member> member = memberRepository.findByUserId(userId);
        if(!member.isPresent()) {
            throw new IllegalArgumentException("회원정보가 없습니다.");
        }

        return basketRepository.findAllByMember_UserIdAndBasketRegisterDateBetween(userId ,startDate, endDate);
    }
}
