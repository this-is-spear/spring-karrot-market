package com.example.carrot.service.user;

import com.example.carrot.domain.user.User;

import java.util.List;

public interface UserService {
    Long join(User user);

    User findOne(Long userId);

    List<User> findAll();
}
