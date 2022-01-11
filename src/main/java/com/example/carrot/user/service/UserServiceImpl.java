package com.example.carrot.user.service;

import com.example.carrot.user.domain.User;
import com.example.carrot.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UUID saveUser(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public User getUser(UUID userId) {
        return userRepository.getUser(userId);
    }

    @Override
    public User updateUserImg(User user) {
        return null;
    }

    @Override
    public User updateUserNickname(User user) {
        return null;
    }
}
