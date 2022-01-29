package com.example.carrot.domain.user;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String loginId; //로그인 ID
    private String name; //사용자 이름
    private String password;
}
