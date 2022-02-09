package com.example.carrot.service.user;

import com.example.carrot.domain.user.User;
import com.example.carrot.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Long join(User user) {
        validateDuplicateMember(user);
        return userRepository.save(user);
    }

    @Override
    public User findOne(Long userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    private void validateDuplicateMember(User user) {
        String loginId = user.getLoginId();
        List<User> findMembers = userRepository.findByLoginId(loginId);
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
