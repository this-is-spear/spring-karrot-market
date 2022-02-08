package com.example.carrot.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public Long save(User user);

    public User findById(Long id);

    public Optional<User> findByLoginId(String loginId);

    public List<User> findAll();
}
