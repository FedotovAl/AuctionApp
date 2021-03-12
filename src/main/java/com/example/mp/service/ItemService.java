package com.example.mp.service;


import com.example.mp.entity.Item;
import com.example.mp.entity.User;
import com.example.mp.repository.ItemRepository;
import com.example.mp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public Item findById(long id){
        return itemRepository.findById(id);
    }

    public void create(long userId, Item item){
        User user = userRepository.findById(userId);
        item.setItemOwner(user);
        itemRepository.create(item);
    }


    public void update(long id, Item item){
        Item i = itemRepository.findById(id);
        i.setName(item.getName());
        i.setDescription(item.getDescription());
        itemRepository.update(i);

    }
}
