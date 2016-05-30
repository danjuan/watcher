package cmt.app.watcher.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static String ToDate(String lo) {
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm:ss");
        return sd.format(date);
    }
}
