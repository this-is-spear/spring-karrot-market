package com.example.carrot.place.repository;

import com.example.carrot.place.domain.Place;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface PlaceRepository {
    UUID save(Place place);
    Place findByPlace_code(UUID place_code);
}
