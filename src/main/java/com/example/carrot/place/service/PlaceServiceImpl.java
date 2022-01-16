package com.example.carrot.place.service;

import com.example.carrot.place.domain.Place;
import com.example.carrot.place.domain.TradingPlace;
import com.example.carrot.place.domain.UserPlace;
import com.example.carrot.place.repository.PlaceRepository;
import com.example.carrot.place.repository.TradingPlaceRepository;
import com.example.carrot.place.repository.UserPlaceRepository;
import com.example.carrot.place.repository.memory.MemoryPlaceRepository;
import com.example.carrot.place.repository.memory.MemoryUserPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-14
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService{

    private final PlaceRepository placeRepository;
    private final TradingPlaceRepository tradingPlaceRepository;
    private final UserPlaceRepository userPlaceRepository;

    @Override
    public UUID savePlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public UUID saveTradingPlace(TradingPlace tradingPlace) {
        return tradingPlaceRepository.save(tradingPlace);
    }

    @Override
    public UUID saveUserPlace(UUID user_id, Place place) {
        UUID uuid;
        if(placeRepository.findByPlace_name(place.getPlace_name()) == null){
            // place 저장
            uuid = savePlace(place);
        }else{
            // 원래 존재하는 place code 를 이용
            uuid = placeRepository.findByPlace_name(place.getPlace_name()).getPlace_code();
        }
        //user place 저장
        UserPlace build = UserPlace.builder().user_id(user_id).place_code(uuid).build();
        userPlaceRepository.save(build);
        return null;
    }

    /**
     * 미완성
     * @param place_code
     * @return
     */
    @Override
    public List<UUID> findByPlace_code(UUID place_code) {
        return null;
    }

    @Override
    public UUID confirmUserPlace(UUID user_id) {
        UserPlace userPlace = userPlaceRepository.findByUser_id(user_id);
        return userPlace.getPlace_code();
    }

    @Override
    public UUID confirmItemPlace(UUID item_id) {
        TradingPlace tradingPlace = tradingPlaceRepository.findByItem_id(item_id);
        return tradingPlace.getPlace_code();
    }
}
