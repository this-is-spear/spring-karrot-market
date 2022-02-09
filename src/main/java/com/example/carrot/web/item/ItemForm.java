package com.example.carrot.web.item;

import com.example.carrot.domain.item.category.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ItemForm {
    private Long itemId;

    @NotNull
    @NotEmpty
    private String itemName;

    @NotNull
    @NotEmpty
    private String itemContent;

    @Max(value = 10000000)
    @Min(value = 0)
    @NotNull
    private int itemPrice;

    @NotNull
    private Category itemCategory;

    private List<MultipartFile> imageFiles;
}
