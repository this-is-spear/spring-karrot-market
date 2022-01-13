package com.example.carrot.items.service;

import com.example.carrot.items.domain.Category;
import com.example.carrot.items.domain.Item;
import com.example.carrot.items.repository.ItemCategoryRepository;
import com.example.carrot.items.repository.ItemDetailsRepository;
import com.example.carrot.items.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{
    private final ItemCategoryRepository itemCategoryRepository;
    private final ItemRepository itemRepository;
    private final ItemDetailsRepository itemDetailsRepository;

    /**
     * <pre>
     * com.example.carrot.items.service
     * &#x3134; ItemServiceImpl.java
     * </pre>
     * @date : 2022-01-12 &#xC624;&#xD6C4; 11:39
     * @author : ImaSpear
     * @version : 1. 0. 0
     * @description : &#xD14C;&#xC2A4;&#xD2B8;&#xC6A9; &#xC544;&#xC774;&#xD15C; &#xB9AC;&#xC2A4;&#xD2B8;
     * @return : &#xD0C0;&#xC774;&#xD2C0; &#xC774;&#xBBF8;&#xC9C0;, &#xC81C;&#xBAA9;, &#xC7A5;&#xC18C;, &#xAC00;&#xACA9;, &#xB313;&#xAE00; &#xC218;, &#xAD00;&#xC2EC; &#xC218;, &#xAC70;&#xB798;&#xC644;&#xB8CC; &#xC720;&#xBB34;
     **/
    @Override
    public Map<String, Object> AllList() {
        Map<String, Object> map = new ConcurrentHashMap<>();

        //item
        itemRepository.getItemList().forEach((key, item) -> {
            log.debug("{} : get item list", getClass());
            log.debug("item Title = {}", item.getTitle());
            log.debug("item Price = {}", item.getPrice());
            log.debug("item RegDate = {}", item.getRegdate());
            log.debug("item Title_image_path {}", item.getTitle_image_path());

            map.put("item", item);
            //comment

            //place

            //purchase
        });
        return map;
    }

    @Override
    public Map<String, Object> ListByPlaceCode(UUID place_code) {
        return null;
    }

    @Override
    public Map<String, Object> ListByCategoryCode(Category category) {
        Map<String, Object> map = new ConcurrentHashMap<>();

        List<UUID> itemListByCategory = itemCategoryRepository.getItemListByCategory(category);
        itemListByCategory.forEach(uuid -> {
            Item item = itemRepository.getItemOne(uuid);
            log.debug("{} : get list by categorycode", getClass());
            log.debug("item Title = {}", item.getTitle());
            log.debug("item Price = {}", item.getPrice());
            log.debug("item RegDate = {}", item.getRegdate());
            log.debug("item Title_image_path {}", item.getTitle_image_path());


            map.put("item", item);
            //comment

            //place

            //purchase

        });
        return map;
    }

    @Override
    public Map<String, Object> ListByCategoryCodeAndPlaceCode(Category category, UUID place_code) {
        return null;
    }

    @Override
    public Map<String, Object> getItemOne(UUID item_id) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        Item item = itemRepository.getItemOne(item_id);

        log.debug("{} : get item one", getClass());
        log.debug("item Title = {}", item.getTitle());
        log.debug("item Price = {}", item.getPrice());
        log.debug("item RegDate = {}", item.getRegdate());
        log.debug("item Title_image_path {}", item.getTitle_image_path());

        map.put("item", item);
        String contents = itemDetailsRepository.getContents(item_id);
        map.put("contents", contents);
        Category category = itemCategoryRepository.getOneItemCategory(item_id);
        map.put("category", category);

        //purchase or reserve
        return map;
    }
}
