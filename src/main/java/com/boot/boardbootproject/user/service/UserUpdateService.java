package com.boot.boardbootproject.user.service;

import com.boot.boardbootproject.user.dto.UserUpdateNameForm;
import com.boot.boardbootproject.user.dto.UserUpdatePasswordForm;

public interface UserUpdateService {
    void updatePassword(UserUpdatePasswordForm form) throws Exception;

    void updateName(UserUpdateNameForm form) throws Exception;
}
