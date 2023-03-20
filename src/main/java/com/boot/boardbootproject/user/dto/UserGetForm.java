package com.boot.boardbootproject.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserGetForm {
    private Long id;

    private String name;

    private String createDate;
}
