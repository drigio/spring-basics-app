package com.example.jwtssecurity.repository;

import java.util.Optional;

import com.example.jwtssecurity.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
    
}