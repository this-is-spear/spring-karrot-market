package com.example.carrot.user.service;

import com.example.carrot.user.domain.User;
import com.example.carrot.user.domain.UserDetails;
import com.example.carrot.user.domain.UserImg;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface UserService {
    UUID saveUser(User user, UserDetails userDetails);
    User getUser(UUID userId);
    UUID updateUserImg(UserImg userImg);
    UUID updateUserNickname(UUID uuid, String updateNickname);
    String getImgPath(UUID uuid);
}
