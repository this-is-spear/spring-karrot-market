package com.example.carrot.domain.item;

import com.example.carrot.domain.item.ItemRepository;
import com.example.carrot.web.filter.CheckThreadLog;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

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
