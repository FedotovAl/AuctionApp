package com.example.mp.service;

import com.example.mp.entity.User;
import com.example.mp.repository.RoleRepository;
import com.example.mp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(long id){
        return userRepository.findById(id);
    }

    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public void create(User regUser){
        regUser.setPassword(passwordEncoder.encode(regUser.getPassword()));
        regUser.setRole(roleRepository.findByName("USER"));
        userRepository.create(regUser);
    }
}
