package com.ssysemployees.users.service;

import org.springframework.stereotype.Service;

import com.ssysemployees.users.domain.User;
import com.ssysemployees.users.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Consulta user por email
     * 
     * @param email
     * @return
     */
    public User getOneByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
