package com.example.carrot.domain.item;

import com.example.carrot.domain.item.category.Category;
import com.example.carrot.domain.images.ItemImage;
import com.example.carrot.domain.images.ItemImageRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class JPAItemRepositoryTest {

    @Autowired
    JPAItemRepository jpaItemRepository;

    @Autowired
    ItemImageRepository uploadImageRepository;

    @Test
    @Transactional
    @DisplayName("아이템 생성")
    @Rollback(value = false)
    void 첫_아이템_생성() {

        ItemImage uploadFile = new ItemImage();
        uploadFile.setUploadFileName("asdf");
        uploadFile.setStoreFileName("asdf");

        ItemImage uploadFile2 = new ItemImage();
        uploadFile2.setUploadFileName("asdf");
        uploadFile2.setStoreFileName("asdf");

        Item item = new Item();
        item.setItemPrice(10000);
        item.setItemContent("첫 번째 아이템");
        item.setItemName("hoho");
        item.setItemCategory(Category.BEAUTY);
        item.setUploadImages(uploadFile);
        jpaItemRepository.save(item);
    }


    @Test
    @Transactional
    @DisplayName("아이템을 삭제하면서 이미지 삭제하기")
    @Rollback(value = false)
    void 아이템을_삭제하면_이미지_삭제하기() {

        ItemImage uploadFile1 = new ItemImage();
        uploadFile1.setUploadFileName("asdf");
        uploadFile1.setStoreFileName("asdf");

        ItemImage uploadFile2 = new ItemImage();
        uploadFile2.setUploadFileName("asdf");
        uploadFile2.setStoreFileName("asdf");

        ItemImage uploadFile3 = new ItemImage();
        uploadFile3.setUploadFileName("asdf");
        uploadFile3.setStoreFileName("asdf");

        Item item = new Item();
        item.setItemPrice(10000);
        item.setItemContent("첫 번째 아이템");
        item.setItemName("hoho");
        item.setItemCategory(Category.BEAUTY);
        item.setUploadImages(uploadFile1);
        item.setUploadImages(uploadFile2);
        item.setUploadImages(uploadFile3);
        jpaItemRepository.save(item);

        jpaItemRepository.delete(item);
    }

}