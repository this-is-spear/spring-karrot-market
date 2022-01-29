package com.example.carrot.web;

import com.example.carrot.domain.user.User;
import com.example.carrot.web.login.LoginForm;
import com.example.carrot.web.session.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "landing";
        }
        User user = (User) session.getAttribute(SessionConst.LOGIN_SESSION);
        if (user == null) {
            return "landing";
        }

        model.addAttribute("user", user);
        return "loginLanding";
    }
}
