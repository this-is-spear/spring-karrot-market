package com.example.carrot.items.repository;

import com.example.carrot.items.domain.Item;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface ItemRepository {
    //저장
    UUID saveItem(Item item);
    //아이템 조회
    Item getItemOne(UUID uuid);
    // 아이템 조회 리스트
    Map<UUID, Item> getItemList();
    //수정
    //삭제
}
