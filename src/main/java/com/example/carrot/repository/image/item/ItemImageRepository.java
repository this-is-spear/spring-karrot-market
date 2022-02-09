package com.example.carrot.repository.image.item;

import com.example.carrot.domain.images.ItemImage;

public interface ItemImageRepository {
    Long save(ItemImage item);
    ItemImage findById(Long id);
}
