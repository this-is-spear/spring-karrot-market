package com.example.carrot.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public User save(User user);

    public User findById(Long id);

    public Optional<User> findByLoginId(String loginId);

    public List<User> findAll();

    public void clearStore();
}
