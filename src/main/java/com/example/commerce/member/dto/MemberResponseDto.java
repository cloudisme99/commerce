package com.example.commerce.member.dto;

import com.example.commerce.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private Long userId;

    public MemberResponseDto(Member member) {
        this.userId = member.getUserId();
    }
}
