package com.ssysemployees.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssysemployees.users.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    
}
