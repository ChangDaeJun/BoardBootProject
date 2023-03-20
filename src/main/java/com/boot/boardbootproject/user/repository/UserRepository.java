package com.boot.boardbootproject.user.repository;

import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.dto.UserGetForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByName(String name);
    boolean existsUserById(Long id);

    @Query("select new com.boot.boardbootproject.user.dto.UserGetForm(u.id, u.name, u.joinDate) from User as u where u.id =: id")
    UserGetForm findGetFormById(Long id);
}
