package com.boot.boardbootproject.likes.service;

import com.boot.boardbootproject.likes.dto.LikeForm;

public interface LikeRegisterService {
    void register(LikeForm form) throws Exception;
}
