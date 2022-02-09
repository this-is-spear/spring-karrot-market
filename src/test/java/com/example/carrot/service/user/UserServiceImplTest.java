package com.example.carrot.service.user;

import com.example.carrot.domain.user.User;
import com.example.carrot.repository.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
//    @Rollback(value = false)
    void 회원가입() {
        User user = new User();
        user.setLoginId("1");
        user.setPassword("1");
        user.setName("hi");
        userService.join(user);
        assertThat(user).isEqualTo(userRepository.findById(user.getId()));
    }

    @Test
//    @Transactional
//    @Rollback(value = false)
    @DisplayName("DB상 같은 loginId가 존재하는 경우 예외 발생")
    void 회원아이디_중복_기입() {
        User user1 = new User();
        user1.setLoginId("1");
        user1.setPassword("1");
        user1.setName("hi");

        userService.join(user1);
        User user2 = new User();
        user2.setLoginId("1");
        user2.setPassword("1");
        user2.setName("hi");

        Assertions.assertThrows(IllegalStateException.class, ()->{
            userService.join(user2);
        });
    }
}