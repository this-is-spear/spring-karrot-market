package com.example.carrot.repository.image.user;

import com.example.carrot.domain.images.UserImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository
@Transactional
public class JPAUserImageRepository implements UserImageRepository{
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
