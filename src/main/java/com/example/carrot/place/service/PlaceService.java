package com.example.carrot.place.service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface PlaceService {
    /**
     * 아이템 위치 등록
     * @param item_id
     * @return place_code
     */
    UUID saveTradingPlace(UUID item_id);

    /**
     * 판매자 위치 등록
     * @param user_id
     * @return place_code
     */
    UUID saveUserPlace(UUID user_id);

    /**
     * 동일 위치 아이템 리스트 조회
     * @param place_code
     * @return item_id_list
     */
    List<UUID> findByPlace_code(UUID place_code);

    /**
     * 유저 위치 확인
     * @param user_id
     * @return place_code
     */
    UUID confirmUserPlace(UUID user_id);

    /**
     * 아이템 위치 확인
     * @param item_id
     * @return place_code
     */
    UUID confirmItemPlace(UUID item_id);
}
