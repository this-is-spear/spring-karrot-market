package com.example.carrot.domain.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository{
        private static Map<Long, User> store = new HashMap<>(); //static 사용
        private static long sequence = 0L; //static 사용
        public User save(User user) {
            user.setId(++sequence);
            log.debug("save: user={}", user);
            store.put(user.getId(), user);
            return user;
        }
        public User findById(Long id) {
            log.debug("UserRepositoryImpl:findById: id={}", id);
            return store.get(id);
        }
        public Optional<User> findByLoginId(String loginId) {
            log.debug("UserRepositoryImpl:findByLoginId: loginId={}", loginId);
            return findAll().stream()
                    .filter(m -> m.getLoginId().equals(loginId))
                    .findFirst();
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
