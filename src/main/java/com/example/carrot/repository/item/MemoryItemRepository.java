package com.example.carrot.repository.item;

import com.example.carrot.domain.item.Item;

import java.util.HashMap;
import java.util.Map;

public class MemoryItemRepository implements ItemRepository{

    private final Map<Long, Item> store = new HashMap<>();
    private long sequence = 0L;

    public Long save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item.getId();
    }

    public Item findById(Long id) {
        return store.get(id);
    }
}
