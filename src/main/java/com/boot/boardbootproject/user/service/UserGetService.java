package com.boot.boardbootproject.user.service;

import com.boot.boardbootproject.user.dto.UserGetForm;
import com.boot.boardbootproject.user.dto.UserLoginForm;

public interface UserGetService {
    UserGetForm getById(Long id);
    UserGetForm getByLogin(UserLoginForm form);
}
