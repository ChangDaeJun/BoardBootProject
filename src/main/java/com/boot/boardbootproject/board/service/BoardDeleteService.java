package com.boot.boardbootproject.board.service;

public interface BoardDeleteService {
    void deleteById(Long id) throws Exception;

    void deleteByUserId(Long userId) throws Exception;
}
