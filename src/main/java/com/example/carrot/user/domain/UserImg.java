package com.example.carrot.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.OneToOne;
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
public class UserImg {
    private UUID user_id;
    private String img_path;
}
