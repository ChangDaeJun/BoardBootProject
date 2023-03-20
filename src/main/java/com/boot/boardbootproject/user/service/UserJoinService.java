package com.boot.boardbootproject.user.service;

import com.boot.boardbootproject.user.dto.UserJoinForm;

public interface UserJoinService {
    Long join(UserJoinForm form);
}
