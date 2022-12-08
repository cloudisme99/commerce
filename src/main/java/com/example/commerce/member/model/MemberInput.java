package com.example.commerce.member.model;

import javax.persistence.Id;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class MemberInput {

    private String userId;
    private String userEmail;
    private String userName;
    private String password;
    private String phone;
    private String zipcode;
    private String address;
}
