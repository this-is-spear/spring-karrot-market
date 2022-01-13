package com.example.carrot.items.repository;

import com.example.carrot.items.domain.ItemDetails;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface ItemDetailsRepository {
    UUID saveItemDetails(ItemDetails itemDetails);
    String getContents(UUID item_uuid);
}
