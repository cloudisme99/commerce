package com.example.commerce.member.controller;

import com.example.commerce.member.entity.Member;
import com.example.commerce.member.service.MemberService;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
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
            request.getUsername(),
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

    //로그인
    @GetMapping("/login/success")
    public ResponseEntity notSession() {
        log.info("로그인 성공");
        Map<String, Object> map = new HashMap<>();
        map.put("result", 1);

        return new ResponseEntity(map, HttpStatus.OK);
    }

    @GetMapping("/login/fail")
    public ResponseEntity hello() {
        log.info("로그인 실패");
        Map<String, Object> map = new HashMap<>();
        map.put("result", 0);

        return new ResponseEntity(map, HttpStatus.OK);
    }

    @GetMapping("/bucket")
    public String test(Principal user) {
        return "user만 접근";
    }


    //회원정보수정(transaction 오류있음)
//    @PutMapping("/member/update")
//    void updateDetail(@RequestParam String userEmail, @RequestBody String userName, String password, String phone, String zipcode, String address) {
//        memberService.updateDetail(userEmail, userName, password, phone, zipcode, address);
//    }

}
