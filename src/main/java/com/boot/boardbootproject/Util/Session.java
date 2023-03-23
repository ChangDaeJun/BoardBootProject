package com.boot.boardbootproject.Util;

import com.boot.boardbootproject.user.dto.UserGetForm;
import jakarta.servlet.http.HttpServletRequest;

public class Session {
    public static Long getUserId(HttpServletRequest request){
        return ((UserGetForm) request.getSession().getAttribute("user")).getId();
    }
}
