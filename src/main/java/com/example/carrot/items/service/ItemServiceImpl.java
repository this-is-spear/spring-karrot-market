package com.example.carrot.items.service;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ItemServiceImpl implements ItemService{

    /*
    * <pre>
    *   com.example.carrot.items.service
    *   ㄴ ItemServiceImpl.java
    * </pre>
    * @date : 2022-01-12 오후 11:39
    * @author : ImaSpear
    * @version : 1. 0. 0
    * @description : 테스트용 아이템 리스트
    * @return : 타이틀 이미지, 제목, 장소, 가격, 댓글 수, 관심 수, 거래완료 유무
    * see :
    */
    @Override
    public Map<String, Object> AllList() {
        //item

        //comment

        //place

        //item_details

        //category
        return null;
    }

    @Override
    public Map<String, Object> ListByPlaceCode(UUID place_code) {
        return null;
    }

    @Override
    public Map<String, Object> getItemOne(UUID item_id) {
        return null;
    }
}
