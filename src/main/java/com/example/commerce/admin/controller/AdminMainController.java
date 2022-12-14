package com.example.commerce.admin.controller;

import com.example.commerce.admin.service.AdminService;
import com.example.commerce.member.entity.Member;
import com.example.commerce.member.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdminMainController {

    private final AdminService adminService;

    //userEmail에 대한 member 조회
    @GetMapping("/admin/memberList")
    List<Member> readMember(@RequestParam String userEmail) {
        return adminService.readMember(userEmail);
    }

    //member 전체 조회
    @GetMapping("/admin/membersList")
    List<Member> readMember() {
        return adminService.readMembers();
    }

    // status수정
    @PutMapping("/admin/updateStatus")
    void updateStatus(@RequestParam String userEmail, @RequestBody String status) {
        adminService.updateStatus(userEmail, status);
    }

    //관리자 지정
    @PutMapping("/admin/adminUser")
    void adminUser(@RequestParam String userEmail, @RequestBody String role) {
        adminService.adminUser(userEmail, role);
    }
}
