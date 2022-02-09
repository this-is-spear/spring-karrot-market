package com.example.carrot.domain.images;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository
@Transactional
public class JPAItemImageRepository implements ItemImageRepository{
    @PersistenceContext
    private EntityManager em;

    public Long save(ItemImage uploadImage) {
        em.persist(uploadImage);
        return uploadImage.getId();
    }

    public ItemImage findById(Long id) {
        return em.find(ItemImage.class, id);
    }
}
