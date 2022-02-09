package com.example.carrot.domain.item;

import com.example.carrot.domain.images.Image;
import com.example.carrot.domain.item.category.Category;
import com.example.carrot.domain.images.ItemImage;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String itemName;
    private String itemContent;
    private int itemPrice;
    @Enumerated(value = EnumType.STRING)
    private Category itemCategory;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemImage> imagesFiles = new ArrayList<>();

    public void setUploadImage(ItemImage uploadImage) {
        uploadImage.setItem(this);
        this.getImagesFiles().add(uploadImage);
    }

    public void setImagesFiles(List<ItemImage> imagesFiles) {
        for (ItemImage imagesFile : imagesFiles) {
            this.setUploadImage(imagesFile);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return id != null && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
