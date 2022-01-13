package com.example.carrot.place.repository.memory;

import com.example.carrot.place.domain.TradingPlace;
import com.example.carrot.place.repository.TradingPlaceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-14
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
@Repository
public class MemoryTradingPlaceRepository implements TradingPlaceRepository {

    Map<UUID, TradingPlace> tradingPlaceMap = new ConcurrentHashMap<>();

    @Override
    public UUID save(TradingPlace tradingPlace) {
        tradingPlaceMap.put(tradingPlace.getItem_id(), tradingPlace);
        return tradingPlace.getItem_id();
    }

    @Override
    public List<TradingPlace> findByPlace_code(UUID place_code) {
        List<TradingPlace> placeList = new ArrayList<>();
        tradingPlaceMap.forEach((key, value) ->{
            if (value.getPlace_code() == place_code) {
                placeList.add(value);
            }
        });
        return placeList;
    }

    @Override
    public TradingPlace findByItem_id(UUID item_id) {
        return tradingPlaceMap.get(item_id);
    }
}
