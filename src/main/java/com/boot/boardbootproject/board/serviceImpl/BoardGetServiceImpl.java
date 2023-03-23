package com.boot.boardbootproject.board.serviceImpl;

import com.boot.boardbootproject.board.dto.BoardGetForm;
import com.boot.boardbootproject.board.dto.BoardListByUserForm;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.board.service.BoardGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardGetServiceImpl implements BoardGetService {
    private final BoardRepository boardRepository;
    @Override
    public BoardGetForm getById(Long id) {
        return boardRepository.findGetFormById(id);
    }

    @Override
    public List<BoardGetForm> getListAll() {
        return boardRepository.findGetFormAll();
    }

    @Override
    public BoardListByUserForm getByUserId(Long userId) {
        List<Long> ids = boardRepository.findIdByUserId(userId);
        List<BoardGetForm> list = new ArrayList<>();
        for(Long id : ids) list.add(getById(id));
        return new BoardListByUserForm(userId, list);
    }
}
