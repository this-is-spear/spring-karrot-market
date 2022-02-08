package com.example.carrot.domain.user;

import com.example.carrot.web.filter.CheckThreadLog;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class JPAUserRepository implements UserRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Long save(User user) {
        em.persist(user);
        return user.getId();
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public Optional<User> findByLoginId(String loginId) {
        TypedQuery<User> query = em.createQuery("select u from User as u where u.loginId = :loginId", User.class);
        query.setParameter("loginId", loginId);
        User user = query.getSingleResult();
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<User> findAll() {
        log.debug("[{}][{}] user repository", MDC.get(CheckThreadLog.LOG_ID), this.getClass().getSimpleName());
        log.debug("no");
        return null;
    }

}
