package com.example.carrot.domain.item;

import com.example.carrot.domain.item.category.Category;
import lombok.Data;

import java.util.List;

@Data
public class Item {
    private Long id;
    private String itemName;
    private String itemContent;
    private int itemPrice;
    private Category itemCategory;
    private List<UploadFile> imagesFiles;
}
