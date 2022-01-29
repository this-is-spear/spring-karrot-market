package com.example.carrot.web.user;

import com.example.carrot.domain.user.User;
import org.springframework.validation.BindingResult;

public interface UserController {

    public String addForm(UserForm user);

    public String save(UserForm user, BindingResult bindingResult);
}
