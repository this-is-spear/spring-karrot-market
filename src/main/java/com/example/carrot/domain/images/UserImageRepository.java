package com.example.carrot.domain.images;

import com.example.carrot.web.filter.CheckThreadLog;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository
@Transactional
public class UserImageRepository implements ImageRepository{
    @PersistenceContext
    private EntityManager em;

    public Long save(UserImage userImage) {
        em.persist(userImage);
        return userImage.getId();
    }

    public UserImage findById(Long id) {
        return em.find(UserImage.class, id);
    }
}
