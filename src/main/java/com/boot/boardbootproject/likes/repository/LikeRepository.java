package com.boot.boardbootproject.likes.repository;

import com.boot.boardbootproject.likes.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    boolean existsByUserIdAndBoardId(Long userId, Long boardId);
    Likes findByUserIdAndBoardId(Long userId, Long boardId);
    @Query("select new java.lang.Long(l.id) from Likes l where l.user.id =:userId")
    List<Long> findIdByUserId(Long userId);
    @Query("select new java.lang.Long(l.id) from Likes l where l.board.id =:boardId")
    List<Long> findIdByBoardId(Long boardId);
}
