package com.example.carrot.items.repository;

import com.example.carrot.items.domain.ItemDetails;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
@Repository
public class ItemDetailsRepositoryImpl implements ItemDetailsRepository{

    Map<UUID, ItemDetails> itemDetailsMap = new ConcurrentHashMap<>();

    @Override
    public UUID saveItemDetails(ItemDetails itemDetails) {
        itemDetailsMap.put(itemDetails.getItem_id(), itemDetails);
        return itemDetails.getItem_id();
    }

    @Override
    public String getContents(UUID item_uuid) {
        return itemDetailsMap.get(item_uuid).getContent();
    }
}
