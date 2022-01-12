package com.example.carrot.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Getter
@Builder
@AllArgsConstructor
public class User {
    private UUID id;
    private String nickname;
    private String password;
}
