package com.example.carrot.service.login;

import com.example.carrot.domain.user.User;

public interface LoginService {
    public User login(String loginId, String password);
}
