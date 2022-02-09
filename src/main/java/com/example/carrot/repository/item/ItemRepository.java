package com.example.carrot.repository.item;

import com.example.carrot.domain.item.Item;

public interface ItemRepository {
    public Long save(Item item);
    public Item findById(Long id);
}
