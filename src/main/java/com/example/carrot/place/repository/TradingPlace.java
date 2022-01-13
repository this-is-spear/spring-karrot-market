package com.example.carrot.place.repository;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface TradingPlace {
    UUID save(TradingPlace tradingPlace);
    TradingPlace findByPlace_code(UUID place_code);
    TradingPlace findByItem_id(UUID item_id);
}
