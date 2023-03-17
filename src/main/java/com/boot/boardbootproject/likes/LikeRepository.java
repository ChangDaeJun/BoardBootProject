package com.boot.boardbootproject.likes;

import com.boot.boardbootproject.domain.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    boolean existsByUserIdAndBoardId(Long userId, Long boardId);

    List<Long> findIdByUserId(Long userId);
}
