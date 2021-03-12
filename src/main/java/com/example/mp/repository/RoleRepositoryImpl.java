package com.example.mp.repository;

import com.example.mp.entity.Role;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public Role findByName(String name) {
        return findAll().stream().filter(role -> role.getName().equals(name)).findAny().orElse(null);
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
