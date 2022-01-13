package com.example.carrot.items.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Builder
@Getter
@AllArgsConstructor
public class ItemCategory {
    private UUID item_id;
    private Category category;
}
