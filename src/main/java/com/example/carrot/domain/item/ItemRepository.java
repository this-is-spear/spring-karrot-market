package com.example.carrot.domain.item;

public interface ItemRepository {
    public Long save(Item item);
    public Item findById(Long id);
}
