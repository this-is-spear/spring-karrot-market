package com.example.carrot.service.login;

import com.example.carrot.domain.user.User;
import com.example.carrot.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{
    private final UserRepository userRepository;

    public User login(String loginId, String password) {
        log.debug("LoginServiceImpl : login [{}]", loginId);
        return userRepository.findByLoginId(loginId)
                .stream()
                .filter(user -> user.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}
