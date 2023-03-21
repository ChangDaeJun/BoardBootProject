package com.boot.boardbootproject.board.serviceImpl;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.board.service.BoardWriteService;
import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BoardWriteServiceImpl implements BoardWriteService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    @Override
    @Transactional
    public Long write(BoardWriteForm form) throws Exception {
        User user = userRepository.findById(form.getUserId()).get();
        Board board = new Board(form, user);
        boardRepository.save(board);
        return board.getId();
    }
}
