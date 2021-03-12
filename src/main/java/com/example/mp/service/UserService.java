package com.example.mp.service;

import com.example.mp.entity.User;
import com.example.mp.repository.RoleRepository;
import com.example.mp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public User findById(long id){
        return userRepository.findById(id);
    }

    public User findByLogin(String name){
        return userRepository.findByLogin(name);
    }

    public void create(User regUser){
        regUser.setRole(roleRepository.findByName("USER"));
        userRepository.create(regUser);
    }
}
