package com.example.mp.repository;

import com.example.mp.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(long id);
    User findByLogin(String name);
    void create(User user);
    void update(User user);
    void deleteById(long id);
}
