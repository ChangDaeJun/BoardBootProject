package com.boot.boardbootproject.comment.repository;

import com.boot.boardbootproject.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
