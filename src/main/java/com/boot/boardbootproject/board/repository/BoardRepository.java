package com.boot.boardbootproject.board.repository;

import com.boot.boardbootproject.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Long> findIdByUserId(Long id);
}
