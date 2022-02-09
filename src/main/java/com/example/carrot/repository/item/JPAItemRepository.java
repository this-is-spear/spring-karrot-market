package com.example.carrot.repository.item;

import com.example.carrot.domain.item.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository
@Transactional
public class JPAItemRepository implements ItemRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Long save(Item item) {
        em.persist(item);
        return item.getId();
    }

    @Override
    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    public void delete(Item item) {
        em.remove(item);
    }
}
