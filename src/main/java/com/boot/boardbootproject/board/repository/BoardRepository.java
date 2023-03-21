package com.boot.boardbootproject.board.repository;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.board.dto.BoardGetForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select new java.lang.Long(b.id) from Board b where b.user.id =:id")
    List<Long> findIdByUserId(Long id);

    @Query("select new com.boot.boardbootproject.board.dto.BoardGetForm(b.id, b.user.name, b.user.id, b.title, b.text, b.view, b.createDate) from Board b where b.id =:id")
    BoardGetForm findGetFormById(Long id);

    @Query("select new com.boot.boardbootproject.board.dto.BoardGetForm(b.id, b.user.name, b.user.id, b.title, b.text, b.view, b.createDate) from Board b")
    List<BoardGetForm> findGetFormAll();

    boolean existsByIdAndUserId(Long id, Long userId);
}
