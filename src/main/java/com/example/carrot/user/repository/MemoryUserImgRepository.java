package com.example.carrot.user.repository;

import com.example.carrot.user.domain.User;
import com.example.carrot.user.domain.UserImg;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class MemoryUserImgRepository implements UserImgRepository{

    Map<UUID, UserImg> userImgMap = new ConcurrentHashMap<>();

    @Override
    public UUID init(UUID uuid) {
        UserImg userImg = UserImg.builder().user_id(uuid).build();
        userImgMap.put(uuid, userImg);
        return uuid;
    }

    @Override
    public UUID save(UserImg userImg) {
        userImgMap.put(userImg.getUser_id(), userImg);
        return userImg.getUser_id();
    }

    @Override
    public String getImagePath(UUID uuid) {
        return userImgMap.get(uuid).getImg_path();
    }
}
