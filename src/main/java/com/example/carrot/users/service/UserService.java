package com.example.carrot.users.service;

import com.example.carrot.users.domain.User;
import com.example.carrot.users.domain.UserDetails;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface UserService {
    UUID saveUser(User user, UserDetails userDetails);
    User getUser(UUID userId);
    void updateUserImg(UUID uuid, String userImg);
    void updateUserNickname(UUID uuid, String updateNickname);
    String getImgPath(UUID uuid);
    UserDetails getUserDetails(UUID uuid);
}