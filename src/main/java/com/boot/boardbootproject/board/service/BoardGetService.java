package com.boot.boardbootproject.board.service;

import com.boot.boardbootproject.board.dto.BoardGetForm;

import java.util.List;

public interface BoardGetService {
    BoardGetForm getById(Long id);

    List<BoardGetForm> getListAll();
}
