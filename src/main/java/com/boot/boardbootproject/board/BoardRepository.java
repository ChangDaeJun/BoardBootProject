package com.boot.boardbootproject.board;

import com.boot.boardbootproject.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
