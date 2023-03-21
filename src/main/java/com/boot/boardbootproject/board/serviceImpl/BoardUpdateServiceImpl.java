package com.boot.boardbootproject.board.serviceImpl;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.board.dto.BoardUpdateForm;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.board.service.BoardUpdateService;
import com.boot.boardbootproject.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BoardUpdateServiceImpl implements BoardUpdateService {
    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public void update(BoardUpdateForm form) throws Exception {
        if(!boardRepository.existsByIdAndUserId(form.getId(), form.getUserId())) throw new Exception();
        Board board = boardRepository.findById(form.getId()).get();
        board.update(form);
    }
}
