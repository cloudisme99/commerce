package com.example.commerce.admin.controller;

import com.example.commerce.admin.service.AdminMemberService;
import com.example.commerce.member.entity.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdminMemberController {

    private final AdminMemberService adminMemberService;

    //userEmail에 대한 member 조회
//    @GetMapping("/admin/memberList")
//    List<Member> readMember(@RequestParam String userEmail) {
//        return adminMemberService.readMember(userEmail);
//    }

    //member 전체 조회
    @GetMapping("/admin/membersList")
    List<Member> readMembers() {
        return adminMemberService.readMembers();
    }

    // status수정
    @PutMapping("/admin/updateStatus")
    void updateStatus(@RequestParam String userEmail, @RequestBody String status) {
        adminMemberService.updateStatus(userEmail, status);
    }

    //관리자 지정
    @PutMapping("/admin/adminUser")
    void adminUser(@RequestParam String userEmail, @RequestBody String role) {
        adminMemberService.adminUser(userEmail, role);
    }
}
