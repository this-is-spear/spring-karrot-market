package com.example.carrot.items.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
@Getter
@Builder
@AllArgsConstructor
public class Item {
//    @Id
//    @GeneratedValue
    private UUID item_id;
    private String title;
    private int price;
    private Timestamp regdate;
    private String title_image_path;

    public Item() {
    }
}
