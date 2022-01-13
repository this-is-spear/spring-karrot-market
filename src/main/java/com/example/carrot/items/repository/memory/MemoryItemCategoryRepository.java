package com.example.carrot.items.repository.memory;

import com.example.carrot.items.domain.Category;
import com.example.carrot.items.domain.ItemCategory;
import com.example.carrot.items.repository.ItemCategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Repository
public class MemoryItemCategoryRepository implements ItemCategoryRepository {

    Map<UUID, ItemCategory> itemCategoryMap = new ConcurrentHashMap<>();

    @Override
    public UUID saveItemCategory(ItemCategory itemCategory) {
        itemCategoryMap.put(itemCategory.getItem_id(), itemCategory);
        return itemCategory.getItem_id();
    }

    @Override
    public Category getOneItemCategory(UUID item_uuid) {
        return itemCategoryMap.get(item_uuid).getCategory();
    }

    @Override
    public List<UUID> getItemListByCategory(Category category) {
        List<UUID> uuidList = new ArrayList<>();
        itemCategoryMap.forEach((key, value) -> {
            if (value.getCategory() == category) {
                uuidList.add(key);
            }
        });
        System.out.println("uuidList = " + uuidList);
        return uuidList;
    }
}
