package com.boot.boardbootproject.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdatePasswordForm {
    private Long id;
    private String password;
}
