package com.xinput.cloud.util;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 15:49
 */
public class DateUtils {

    public static final String DATE_TIME_TIMESTAMP_FORMATTER_STRING = "yyyyMMddHHmmss";

    public static final String DATE_TIME_FORMATTER_STRING = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMATTER_STRING = "yyyy-MM-dd";

    public static final String TIME_FORMATTER_STRING = "HH:mm:ss";

    private static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static final DateTimeFormatter DATE_TIME_TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_TIMESTAMP_FORMATTER_STRING);

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER_STRING);

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMATTER_STRING);

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMATTER_STRING);

    public static String formatIso8601Date(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT);
        df.setTimeZone(new SimpleTimeZone(8 * 60 * 60 * 1000, "GMT"));
        return df.format(date);
    }
}
