package com.example.carrot.users.service;

import com.example.carrot.users.domain.User;
import com.example.carrot.users.domain.UserDetails;
import com.example.carrot.users.repository.*;
import com.example.carrot.users.repository.memory.MemoryUserDetailsRepository;
import com.example.carrot.users.repository.memory.MemoryUserImgRepository;
import com.example.carrot.users.repository.memory.MemoryUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class UserServiceTest {
    UserService userService;
    UserRepository userRepository;
    UserDetailsRepository userDetailsRepository;
    UserImgRepository userImgRepository;

    @BeforeEach
    void setUp() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        userService = applicationContext.getBean("userService", UserService.class);
        userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        userDetailsRepository = applicationContext.getBean("userDetailsRepository",UserDetailsRepository.class);
        userImgRepository = applicationContext.getBean("userImgRepository", UserImgRepository.class);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void joinTest() throws Exception{
        //given
        User user = User.builder().nickname("spear").password("password").build();
        UserDetails userDetails = UserDetails.builder().name("keon").phone_number("010-0000-0000").build();
        //when
        UUID uuid = userService.saveUser(user, userDetails);
        //then
        String nickname = userRepository.getUser(uuid).getNickname();
        Assertions.assertThat(nickname).isEqualTo(user.getNickname());
    }

    @Test
    @DisplayName("닉네임 업데이트 테스트")
    public void updateNickname() throws Exception{
        //given
        User user = User.builder().nickname("spear").password("password").build();
        UserDetails userDetails = UserDetails.builder().name("keon").phone_number("010-0000-0000").build();
        //when
        UUID uuid = userService.saveUser(user, userDetails);

        //then
        String nickname = "updateNickname";
        userService.updateUserNickname(uuid, nickname);
        Assertions.assertThat(userRepository.getUser(uuid).getNickname()).isNotEqualTo(user.getNickname());
    }

    @Test
    @DisplayName("기본 설정 이미지일 때 보여주는 화면")
    public void loadingUserNonImage() throws Exception{
        //given
        User user = User.builder().nickname("spear").password("password").build();
        UserDetails userDetails = UserDetails.builder().name("keon").phone_number("010-0000-0000").build();
        //when
        UUID uuid = userService.saveUser(user, userDetails);
        String imgPath = userService.getImgPath(uuid);
        System.out.println("imgPath = " + imgPath);
        //then
        Assertions.assertThat(imgPath).isEqualTo("static/images/default-profile.jpg");
    }

    @Test
    @DisplayName("이미지 업데이트 테스트")
    public void updateImagePathTest() throws Exception{
        //given
        User user = User.builder().nickname("spear").password("password").build();
        UserDetails userDetails = UserDetails.builder().name("keon").phone_number("010-0000-0000").build();
        //when
        UUID uuid = userService.saveUser(user, userDetails);
        //then
        String updateImgPath = "/path/new-profile.jpg";
        userService.updateUserImg(uuid, updateImgPath);
    }

    @Test
    @DisplayName("간단한 유저 정보 조회 테스트")
    public void getUserTest() throws Exception{
        //given
        User user = User.builder().nickname("spear").password("password").build();
        UserDetails userDetails = UserDetails.builder().name("keon").phone_number("010-0000-0000").build();
        //when
        UUID uuid = userService.saveUser(user, userDetails);
        //then
        User getUser = userService.getUser(uuid);
        String imgPath = userService.getImgPath(uuid);
        UserDetails details = userService.getUserDetails(uuid);
        System.out.println("getUser = " + getUser.toString());
        System.out.println("imgPath = " + imgPath);
        System.out.println("details = " + details.toString());
    }

    @Configuration
    static class UserConfig{

        @Bean
        UserRepository userRepository(){
            return new MemoryUserRepository();
        }

        @Bean
        UserDetailsRepository userDetailsRepository(){
            return new MemoryUserDetailsRepository();
        }

        @Bean
        UserImgRepository userImgRepository(){
            return new MemoryUserImgRepository();
        }

        @Bean
        UserService userService(){
            return new UserServiceImpl(userRepository(), userDetailsRepository(), userImgRepository());
        }

    }
}