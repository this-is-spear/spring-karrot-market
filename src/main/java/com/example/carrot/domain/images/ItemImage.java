package com.example.carrot.domain.images;

import com.example.carrot.domain.item.Item;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@DiscriminatorValue("upload_images")
public class ItemImage extends Image{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public ItemImage(String originalFilename, String storeFileName) {
        super(originalFilename, storeFileName);
    }
}
