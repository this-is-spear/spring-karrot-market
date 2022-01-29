package com.example.carrot.web.login;

import com.example.carrot.domain.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm{
    @NotEmpty
    private String loginId; //로그인 ID
    @NotEmpty
    private String password;
}