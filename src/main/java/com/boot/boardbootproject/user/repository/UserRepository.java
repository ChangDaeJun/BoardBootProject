package com.boot.boardbootproject.user.repository;

import com.boot.boardbootproject.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByName(String name);
    boolean existsUserById(Long id);
    Optional<User> findById(Long id);
}
