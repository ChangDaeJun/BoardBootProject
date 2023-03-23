package com.boot.boardbootproject.board.service;

import com.boot.boardbootproject.board.dto.BoardUpdateForm;

public interface BoardUpdateService {
    void update(BoardUpdateForm form) throws Exception;
    void addView(Long boardId);
}
