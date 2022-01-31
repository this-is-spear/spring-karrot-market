package com.example.carrot.web.user;

import com.example.carrot.domain.user.User;
import com.example.carrot.domain.user.UserRepository;
import com.example.carrot.web.filter.CheckThreadLog;
import com.example.carrot.web.login.LoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    private final UserRepository userRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("user") UserForm user) {
        log.debug("[{}] addForm", MDC.get(CheckThreadLog.LOG_ID));
        return "users/addUserForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("user") UserForm user, BindingResult bindingResult) {
        log.debug("[{}] add User", MDC.get(CheckThreadLog.LOG_ID));

        if (bindingResult.hasErrors()) {
            return "users/addUserForm";
        }

        log.debug("[{}] add User Complete", MDC.get(CheckThreadLog.LOG_ID));
        User temp_user = new User();
        temp_user.setLoginId(user.getLoginId());
        temp_user.setName(user.getName());
        temp_user.setPassword(user.getPassword());
        userRepository.save(temp_user);
        return "redirect:/";
    }
}