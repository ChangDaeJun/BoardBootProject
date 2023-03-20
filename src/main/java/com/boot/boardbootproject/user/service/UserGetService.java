package com.boot.boardbootproject.user.service;

import com.boot.boardbootproject.user.dto.UserGetForm;

public interface UserGetService {
    UserGetForm getUserBy(Long id);
}
