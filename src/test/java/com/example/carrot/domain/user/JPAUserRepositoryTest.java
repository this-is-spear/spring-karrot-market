package com.example.carrot.domain.user;

import com.example.carrot.domain.images.UserImage;
import com.example.carrot.web.WebConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JPAUserRepositoryTest {

    @Autowired
    private WebConfig webConfig;

    @Autowired
    private JPAUserRepository jpaUserRepository;

    @Test
    @DisplayName("유저 저장하기")
    @Transactional
    @Rollback(value = false)
    void saveUser() {

        User user = new User();
        user.setLoginId("aa");
        user.setPassword("a");
        user.setName("hi");
        UserImage userImage = new UserImage("asf", "asdf");
        user.setUserImage(userImage);

        jpaUserRepository.save(user);

    }
}