package com.example.carrot.web.login;

import com.example.carrot.domain.login.LoginService;
import com.example.carrot.domain.user.User;
import com.example.carrot.web.filter.CheckThreadLog;
import com.example.carrot.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) {
        log.debug("[{}] login Form", MDC.get(CheckThreadLog.LOG_ID));
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm loginForm,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request) {

        log.debug("[{}][{}][{}] log in", MDC.get(CheckThreadLog.LOG_ID), loginForm.getLoginId(), loginForm.getPassword());

        if (bindingResult.hasErrors()) {
            log.debug("[{}][{}] login fail", MDC.get(CheckThreadLog.LOG_ID),"bindingResult error");

            log.debug("bindingResult has Errors : {}", "오류가 발생했습니다.");
            return "login/loginForm";
        }

        User loginUser = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
//        log.debug("login : {}", loginUser);

        if (loginUser == null) {
            log.debug("[{}][{}] login fail", MDC.get(CheckThreadLog.LOG_ID),"아이디 또는 비밀번호가 맞지 않습니다.");
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        log.debug("[{}][{}][{}] log in Complete", MDC.get(CheckThreadLog.LOG_ID), loginForm.getLoginId(), loginForm.getPassword());

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_SESSION, loginUser);
        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}