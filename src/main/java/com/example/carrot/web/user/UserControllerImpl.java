package com.example.carrot.web.user;

import com.example.carrot.domain.user.User;
import com.example.carrot.repository.user.UserRepository;
import com.example.carrot.service.user.UserService;
import com.example.carrot.web.filter.CheckThreadLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserControllerImpl implements UserController{

    private final UserService userService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("user") UserForm user) {
        log.debug("[{}] addForm", MDC.get(CheckThreadLog.LOG_ID));
        return "users/addUserForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("user") UserForm user, BindingResult bindingResult) {
        log.debug("[{}] add User", MDC.get(CheckThreadLog.LOG_ID));

        if (bindingResult.hasErrors()) {
            log.debug("[{}][{}] join fail", MDC.get(CheckThreadLog.LOG_ID),"bindingResult error");
            log.debug("bindingResult has Errors : {}, {}", "오류가 발생했습니다.", bindingResult.getFieldError());
            return "users/addUserForm";
        }

        log.debug("[{}] add User Complete", MDC.get(CheckThreadLog.LOG_ID));
        User temp_user = new User();
        temp_user.setLoginId(user.getLoginId());
        temp_user.setName(user.getName());
        temp_user.setPassword(user.getPassword());
        try {
            userService.join(temp_user);
        } catch (IllegalStateException e) {
            log.debug("[{}][{}] join fail in user service throw IllegalStateException", MDC.get(CheckThreadLog.LOG_ID), e.getMessage());
            bindingResult.reject("user.error.already", "이미 존재하는 회원입니다.");
            return "users/addUserForm";
        }
        return "redirect:/";
    }
}
