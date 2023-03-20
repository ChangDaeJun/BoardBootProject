package com.boot.boardbootproject.board.repository;

import com.boot.boardbootproject.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
