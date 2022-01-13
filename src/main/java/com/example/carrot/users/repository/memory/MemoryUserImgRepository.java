package com.example.carrot.users.repository.memory;

import com.example.carrot.users.domain.UserImg;
import com.example.carrot.users.repository.UserImgRepository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class MemoryUserImgRepository implements UserImgRepository {

    Map<UUID, UserImg> userImgMap = new ConcurrentHashMap<>();

    @Override
    public void init(UUID uuid) {
        UserImg userImg = UserImg.builder().user_id(uuid).build();
        userImgMap.put(uuid, userImg);
    }

    @Override
    public void save(UUID uuid, String userImgPath) {
        UserImg userImg = userImgMap.get(uuid);
        UserImg updateUserImg = UserImg.builder().user_id(userImg.getUser_id()).img_path(userImgPath).build();
        userImgMap.put(uuid, updateUserImg);
    }

    @Override
    public String getImagePath(UUID uuid) {
        return userImgMap.get(uuid).getImg_path();
    }
}
