package com.example.carrot.domain.images;

import com.example.carrot.domain.item.Item;
import com.example.carrot.domain.item.ItemRepository;

public interface ItemImageRepository {
    Long save(ItemImage item);
    ItemImage findById(Long id);
}
