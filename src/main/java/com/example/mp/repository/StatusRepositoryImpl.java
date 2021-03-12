package com.example.mp.repository;

import com.example.mp.entity.Status;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class StatusRepositoryImpl implements StatusRepository{

    private final SessionFactory sessionFactory;

    @Override
    public List<Status> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Status", Status.class).getResultList();
    }

    @Override
    public Status findById(long id) {
        return null;
    }

    @Override
    public Status findByName(String name) {
        return findAll().stream().filter(status -> status.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public void create(Status status) {

    }

    @Override
    public void update(Status status) {

    }

    @Override
    public void deleteById(long id) {

    }
}
