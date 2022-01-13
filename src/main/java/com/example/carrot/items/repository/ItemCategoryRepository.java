package com.example.carrot.items.repository;

import com.example.carrot.items.domain.Category;
import com.example.carrot.items.domain.ItemCategory;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface ItemCategoryRepository {
    UUID saveItemCategory(ItemCategory itemCategory);
    Category getOneItemCategory(UUID item_uuid);
    List<UUID> getItemListByCategory(Category category);
}
