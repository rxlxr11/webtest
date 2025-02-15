package yb.jsptest1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static Date stringToDate(String str) {
        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 根据实际的日期格式调整
        try {
            date =  sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return date;

    }

}
