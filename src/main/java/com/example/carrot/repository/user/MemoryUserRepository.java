package com.example.carrot.repository.user;

import com.example.carrot.domain.user.User;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class MemoryUserRepository implements UserRepository {
        private static Map<Long, User> store = new HashMap<>(); //static 사용
        private static long sequence = 0L; //static 사용
        public Long save(User user) {
            user.setId(++sequence);
            log.debug("save: user={}", user);
            store.put(user.getId(), user);
            return user.getId();
        }
        public User findById(Long id) {
            log.debug("UserRepositoryImpl:findById: id={}", id);
            return store.get(id);
        }
        public List<User> findByLoginId(String loginId) {
            log.debug("UserRepositoryImpl:findByLoginId: loginId={}", loginId);
            return findAll().stream()
                    .filter(m -> m.getLoginId().equals(loginId))
                    .collect(Collectors.toList());
        }
        public List<User> findAll() {
            log.debug("UserRepositoryImpl:findAll");
            return new ArrayList<>(store.values());
        }

        public void clearStore() {
            log.debug("UserRepositoryImpl:clearStore");
            store.clear();
        }
}
