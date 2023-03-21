package com.boot.boardbootproject.board.repository;

import com.boot.boardbootproject.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select new java.lang.Long(b.id) from Board b where b.user.id =:id")
    List<Long> findIdByUserId(Long id);

    boolean existsByIdAndUserId(Long id, Long userId);
}
