package com.boot.boardbootproject.user.dto;

import com.boot.boardbootproject.Util.DateFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserGetForm {
    private Long id;

    private String name;

    private String createDate;

    public UserGetForm(Long id, String name, Date createDate) {
        this.id = id;
        this.name = name;
        this.createDate = DateFormat.getYYYYMMdd(createDate);
    }
}
