package yb.ajaxtest5.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    public static String dateToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}
