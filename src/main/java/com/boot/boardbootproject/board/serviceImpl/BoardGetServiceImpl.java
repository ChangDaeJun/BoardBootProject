package com.boot.boardbootproject.board.serviceImpl;

import com.boot.boardbootproject.board.dto.BoardGetForm;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.board.service.BoardGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
