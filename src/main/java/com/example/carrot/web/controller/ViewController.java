package com.example.carrot.web.controller;


import com.example.carrot.items.domain.Item;
import com.example.carrot.users.domain.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

public interface ViewController {
    //랜딩 페이지
    public String landing(@SessionAttribute User user);
    //로그인 페이지
    public String logIn(@ModelAttribute User user);
    //회원가입 페이지
    public String join();
    public String join(@ModelAttribute User user);

}
