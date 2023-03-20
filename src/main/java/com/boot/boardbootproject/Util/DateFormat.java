package com.boot.boardbootproject.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateFormat {

    public static String getYYYYMMdd(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static Date now(){
        return new Date(System.currentTimeMillis());
    }
}
