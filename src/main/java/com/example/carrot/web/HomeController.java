package com.example.carrot.web;

import com.example.carrot.domain.user.User;
import com.example.carrot.web.filter.CheckThreadLog;
import com.example.carrot.web.login.LoginForm;
import com.example.carrot.web.session.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        log.debug("[{}] home controller", MDC.get(CheckThreadLog.LOG_ID));

        HttpSession session = request.getSession(false);
        if (session == null) {
            log.debug("[{}] session null", MDC.get(CheckThreadLog.LOG_ID));

            return "landing";
        }
        User user = (User) session.getAttribute(SessionConst.LOGIN_SESSION);
        if (user == null) {
            log.debug("[{}] user null", MDC.get(CheckThreadLog.LOG_ID));
            return "landing";
        }

        log.debug("[{}] login check complete", MDC.get(CheckThreadLog.LOG_ID));
        model.addAttribute("user", user);
        return "loginLanding";
    }
}
