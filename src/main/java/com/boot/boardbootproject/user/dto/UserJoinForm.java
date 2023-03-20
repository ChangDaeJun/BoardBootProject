package com.boot.boardbootproject.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJoinForm {
    private String email;
    private String password;
    private String name;
}
