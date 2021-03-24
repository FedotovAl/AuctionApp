package com.example.mp.repository;

import com.example.mp.entity.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> findAll();
    Item findById(long id);
    void create(Item item);
    void update(Item item);
    void deleteById(long id);
}
