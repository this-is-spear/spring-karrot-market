package com.example.carrot.user.repository;

import com.example.carrot.user.domain.UserDetails;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface UserDetailsRepository {
    UUID init(UUID uuid, UserDetails userDetails);
    UserDetails getUserDetails(UUID uuid);
}
