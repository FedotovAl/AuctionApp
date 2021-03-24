package com.example.mp.repository;

import com.example.mp.entity.Item;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ItemRepositoryImpl implements ItemRepository{

    private final SessionFactory sessionFactory;

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Item findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Item.class, id);
    }

    @Override
    public void create(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    @Override
    public void update(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(item);
    }

    @Override
    public void deleteById(long id) {

    }
}
