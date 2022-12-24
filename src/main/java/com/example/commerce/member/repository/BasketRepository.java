package com.example.commerce.member.repository;

import com.example.commerce.member.entity.Basket;
import com.example.commerce.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, String> {


}
