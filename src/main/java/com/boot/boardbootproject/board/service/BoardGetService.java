package com.boot.boardbootproject.board.service;

import com.boot.boardbootproject.board.dto.BoardGetForm;
import com.boot.boardbootproject.board.dto.BoardListByUserForm;

import java.util.List;

public interface BoardGetService {
    BoardGetForm getById(Long id);

    List<BoardGetForm> getListAll();

    BoardListByUserForm getByUserId(Long userId);
}
