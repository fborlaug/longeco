package com.ambita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambita.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
