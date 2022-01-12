package com.example.carrot.items.repository;

import com.example.carrot.items.domain.Item;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ItemRepositoryImpl implements ItemRepository {
    Map<UUID, Item> itemMap = new ConcurrentHashMap<>();

    @Override
    public UUID saveItem(Item item) {
        UUID uuid = UUID.randomUUID();
        Item build = Item.builder().item_id(uuid).title(item.getTitle()).price(item.getPrice()).title_image_path(item.getTitle_image_path()).build();
        itemMap.put(uuid, build);
        return uuid;
    }

    @Override
    public Item getItemOne(UUID uuid) {
        return itemMap.get(uuid);
    }

    @Override
    public Map<UUID, Item> getItemList() {
        return itemMap;
    }
}
