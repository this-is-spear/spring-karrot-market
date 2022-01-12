package com.example.carrot.items.repository;

import com.example.carrot.items.domain.ItemDetails;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface ItemDetailsRepository {
    UUID saveItemDetails(UUID item_uuid);
    ItemDetails getItemDetails(UUID item_uuid);
}
