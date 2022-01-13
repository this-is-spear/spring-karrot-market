package com.example.carrot.place.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
@Getter
@Builder
@AllArgsConstructor
public class UserPlace {
    private UUID user_id;
    private UUID place_code;
}
