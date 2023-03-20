package com.boot.boardbootproject.board.service;

import com.boot.boardbootproject.board.dto.BoardWriteForm;

public interface BoardWriteService {
    Long write(BoardWriteForm form) throws Exception;
}
