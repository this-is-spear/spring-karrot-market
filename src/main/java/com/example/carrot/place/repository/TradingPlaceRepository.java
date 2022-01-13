package com.example.carrot.place.repository;

import com.example.carrot.place.domain.TradingPlace;

import java.util.List;
import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface TradingPlaceRepository {
    UUID save(TradingPlace tradingPlace);
    List<TradingPlace> findByPlace_code(UUID place_code);
    TradingPlace findByItem_id(UUID item_id);
}
