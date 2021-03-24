package com.example.mp.repository;

import com.example.mp.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository{

    private final SessionFactory sessionFactory;

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).getResultList();

    }

    @Override
    public User findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User findByLogin(String targetLogin) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from User where login = :paramLogin";
        Query query = session.createQuery(hql);
        query.setParameter("paramLogin", targetLogin);
        return (User)query.getResultStream().findAny().orElse(null);
    }

    @Override
    public void create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(long id) {

    }
}
