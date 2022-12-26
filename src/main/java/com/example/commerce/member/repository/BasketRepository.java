package com.example.commerce.member.repository;

import com.example.commerce.member.entity.Basket;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, String> {

    List<Basket> findByMember_UserId(Long userId);

    List<Basket> findAllByMember_UserIdAndBasketRegisterDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
    Basket findBasketByMember_UserIdAndItem_ItemId(Long userId, Long itemId);

}
