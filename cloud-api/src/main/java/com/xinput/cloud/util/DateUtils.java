package com.xinput.cloud.util;

import java.time.format.DateTimeFormatter;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 15:49
 */
public class DateUtils {

    public static final String DATE_TIME_TIMESTAMP_FORMATTER_STRING = "yyyyMMddHHmmss";

    public static final String DATE_TIME_FORMATTER_STRING = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMATTER_STRING = "yyyy-MM-dd";

    public static final String TIME_FORMATTER_STRING = "HH:mm:ss";

    public static final DateTimeFormatter DATE_TIME_TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_TIMESTAMP_FORMATTER_STRING);

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER_STRING);

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMATTER_STRING);

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMATTER_STRING);

}
