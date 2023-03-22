package com.boot.boardbootproject.comment.serviceImpl;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.comment.Comment;
import com.boot.boardbootproject.comment.dto.CommentWriteForm;
import com.boot.boardbootproject.comment.repository.CommentRepository;
import com.boot.boardbootproject.comment.service.CommentWriteService;
import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CommentWriteServiceImpl implements CommentWriteService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public Long write(CommentWriteForm form) throws Exception {
        User user = userRepository.findById(form.getUserId()).get();
        Board board = boardRepository.findById(form.getBoardId()).get();
        Comment comment = new Comment(form, board, user);
        commentRepository.save(comment);
        return comment.getId();
    }
}
