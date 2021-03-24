package com.example.mp.repository;

import com.example.mp.entity.Status;

import java.util.List;

public interface StatusRepository {
    List<Status> findAll();
    Status findById(long id);
    Status findByName(String name);
    void create(Status status);
    void update(Status status);
    void deleteById(long id);
}
