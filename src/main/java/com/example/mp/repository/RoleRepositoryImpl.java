package com.example.mp.repository;

import com.example.mp.entity.Role;
import com.example.mp.entity.Status;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class RoleRepositoryImpl implements RoleRepository{

    private final SessionFactory sessionFactory;

    @Override
    public List<Role> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role findById(long id) {
        return null;
    }

    @Override
    public Role findByName(String targetName) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Role where name = :paramName";
        Query query = session.createQuery(hql);
        query.setParameter("paramName", targetName);
        return (Role)query.getResultStream().findAny().orElse(null);
    }

    @Override
    public void create(Role role) {

    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void deleteById(long id) {

    }
}
