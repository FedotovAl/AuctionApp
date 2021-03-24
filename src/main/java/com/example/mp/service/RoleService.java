package com.example.mp.service;

import com.example.mp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;
}
