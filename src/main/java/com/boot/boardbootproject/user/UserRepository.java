package com.boot.boardbootproject.user;

import com.boot.boardbootproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
