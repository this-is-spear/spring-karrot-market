package com.example.carrot.web.item;

import com.example.carrot.domain.item.category.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ItemForm {
    private Long itemId;
    private String itemName;
    private String itemContent;
    private int itemPrice;
    private Category itemCategory;
    private List<MultipartFile> imageFiles;
}
