package com.example.commerce.member.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String userEmail;

    @NotBlank(message = "이름을 입력해주세요.")
    private String userName;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "핸드폰번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])-(\\d{3,4})-(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phone;

    @NotBlank(message = "우편번호를 입력해주세요.")
    private String zipcode;

    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    private String status;
    private boolean adminYn;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;


}
