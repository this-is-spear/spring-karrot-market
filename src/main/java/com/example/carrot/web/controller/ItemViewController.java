package com.example.carrot.web.controller;

import com.example.carrot.items.domain.*;
import com.example.carrot.users.domain.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ItemViewController {

    //get 요청 아이템 추가 페이지
    public String addItem();
    //post 요청 아이템 추가 -> 리다이렉트
    public String addItem(@ModelAttribute Item item,
                          @ModelAttribute ItemCategory itemCategory,
                          @ModelAttribute ItemDetails itemDetails,
                          @ModelAttribute ItemImages itemImage,
                          @SessionAttribute User user);
    //get 요청 아이템 수정 페이지
    public String getEditItem(@PathVariable UUID itemId, Model model, @SessionAttribute User user);
    //Post 요청 아이템 수정 -> 리다이렉트
    public String postEditItem(@ModelAttribute Item item,                        @ModelAttribute ItemCategory itemCategory,
                               @ModelAttribute ItemDetails itemDetails,
                               @ModelAttribute ItemImages itemImage);
    //get 요청 아이템 상품 페이지
    public String item(@PathVariable UUID itemId, Model model);
    //get 요청 아이템 메인 페이지
    public String itemList(@PathVariable UUID placeId);
    //get 요청 판매자 판매 상품 리스트 페이지
    public String itemInItemList(@PathVariable UUID itemId);
}
