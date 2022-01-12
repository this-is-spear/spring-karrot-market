package com.example.carrot.user.service;

import com.example.carrot.user.domain.User;
import com.example.carrot.user.domain.UserDetails;
import com.example.carrot.user.repository.UserDetailsRepository;
import com.example.carrot.user.repository.UserImgRepository;
import com.example.carrot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by Imaspear on 2022-01-12
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final UserImgRepository userImgRepository;

    @Override
    public UUID saveUser(User user, UserDetails userDetails){
        // User 저장 return User id
        UUID uuid = userRepository.saveUser(user);
        // User Details 저장
        userDetailsRepository.init(uuid, userDetails);
        // User Img 저장
        userImgRepository.init(uuid);
        return uuid;
    }

    @Override
    public User getUser(UUID userId) {
        return userRepository.getUser(userId);
    }

    @Override
    public void updateUserImg(UUID uuid, String userImg) {
        userImgRepository.save(uuid, userImg);
    }

    @Override
    public void updateUserNickname(UUID uuid, String updateNickname) {
        userRepository.updateUserNickname(uuid, updateNickname);
    }

    @Override
    public String getImgPath(UUID uuid) {
        String imagePath = userImgRepository.getImagePath(uuid);
        return Objects.requireNonNullElse(imagePath, "static/images/default-profile.jpg");
    }

    @Override
    public UserDetails getUserDetails(UUID uuid) {
        return userDetailsRepository.getUserDetails(uuid);
    }
}
