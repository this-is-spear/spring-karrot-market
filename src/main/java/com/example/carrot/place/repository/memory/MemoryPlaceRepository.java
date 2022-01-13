package com.example.carrot.place.repository.memory;

import com.example.carrot.place.domain.Place;
import com.example.carrot.place.repository.PlaceRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2022-01-14
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
@Repository
public class MemoryPlaceRepository implements PlaceRepository {

    Map<UUID, Place> placeMap = new ConcurrentHashMap<>();

    @Override
    public UUID save(Place place) {
        UUID uuid = UUID.randomUUID();
        Place build = Place.builder().place_code(uuid).place_name(place.getPlace_name()).build();
        placeMap.put(uuid, build);
        return uuid;
    }

    @Override
    public Place findByPlace_code(UUID place_code) {
        return placeMap.get(place_code);
    }

    @Override
    public Place findByPlace_name(String place_name) {
        for (Map.Entry<UUID, Place> entry : placeMap.entrySet()) {
            Place place = entry.getValue();
            if (Objects.equals(place.getPlace_name(), place_name)) {
                return place;
            }
        }
        return null;
    }
}
