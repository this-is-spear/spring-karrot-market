package com.example.carrot.web.controller;

import com.example.carrot.users.domain.User;
import com.example.carrot.users.domain.UserDetails;
import com.example.carrot.users.domain.UserImg;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface ProfileViewController {
    // 마이 페이지
    public String myProfile(@PathVariable UUID userId, Model model);
    // 프로필 수정 페이지
    public String getEdit(@PathVariable UUID userId, Model model);
    public String postEdit(@ModelAttribute User user,
                           @ModelAttribute UserImg userImg,
                           Model model);
    // 판매 내역 리스트 페이지
    public String itemListByMyUserId(@PathVariable UUID userId,
                                     Model model);
    // 관신 목록 페이지
    public String itemListByHeart(@PathVariable UUID userId,
                                  Model model);
}
