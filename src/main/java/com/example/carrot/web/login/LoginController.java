package com.example.carrot.web.login;

import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

public interface LoginController {
    public String loginForm(LoginForm loginForm);

    public String login(LoginForm loginForm, BindingResult bindingResult,
                        HttpServletRequest request);

    public String logout(HttpServletRequest request);
}