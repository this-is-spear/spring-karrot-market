package com.example.carrot.items.service;

import com.example.carrot.items.domain.Category;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface ItemService {
    Map<String, Object> AllList();
    Map<String, Object> ListByPlaceCode(UUID place_code);
    Map<String, Object> ListByCategoryCode(Category category);
    Map<String, Object> ListByCategoryCodeAndPlaceCode(Category category, UUID place_code);
    Map<String, Object> getItemOne(UUID item_id);
}
