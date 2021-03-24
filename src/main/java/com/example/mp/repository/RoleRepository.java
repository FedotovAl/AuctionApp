package com.example.mp.repository;

import com.example.mp.entity.Role;

import java.util.List;

public interface RoleRepository {
    List<Role> findAll();
    Role findById(long id);
    Role findByName(String name);
    void create(Role role);
    void update(Role role);
    void deleteById(long id);
}
