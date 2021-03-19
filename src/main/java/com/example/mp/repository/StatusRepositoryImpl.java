package com.example.mp.repository;

import com.example.mp.entity.Status;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public Status findByName(String targetName) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Status where name = :paramName";
        Query query = session.createQuery(hql);
        query.setParameter("paramName", targetName);
        return (Status)query.getResultStream().findAny().orElse(null);
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
