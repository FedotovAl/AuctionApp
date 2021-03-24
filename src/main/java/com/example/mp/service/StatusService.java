package com.example.mp.service;

import com.example.mp.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class StatusService {

    private final StatusRepository statusRepository;
}
