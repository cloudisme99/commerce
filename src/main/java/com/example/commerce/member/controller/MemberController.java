package com.example.commerce.member.controller;

import com.example.commerce.member.entity.Member;
import com.example.commerce.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // @@RequiredArgsConstructor가 대체해줌
/*    public MemberController(MemberService memberService) {
        this.memberService = memberService;
   }*/

    @PostMapping("/member/register")
    public void register(@RequestBody Member request) {

        memberService.register(
            request.getUserEmail(),
            request.getUserName(),
            request.getPassword(),
            request.getPhone(),
            request.getZipcode(),
            request.getAddress()
        );
    }

//    @PostMapping("/member/updatePassword")
//    public void updatePassword(@RequestBody Member request) {
//        memberService.updatePassword(request.getUserEmail());
//    }


}
