package com.example.carrot.users.domain;

import lombok.*;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Getter
@Builder
@AllArgsConstructor
@ToString
public class User {
    private UUID id;
    private String nickname;
    private String password;
}
