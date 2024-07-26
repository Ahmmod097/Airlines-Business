package com.airlines.business.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class DateTimeUtils {
    public static Date getCurrentDate() {
        return new Date();
    }

    public static long getDateDifference(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillis = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillis,TimeUnit.MILLISECONDS);
    }

    public static String formatDate(Date date, String dateFormat) {
        return (date == null || StringUtils.isBlank(dateFormat))
                ? ""
                : new SimpleDateFormat(dateFormat).format(date);
    }

    public static String formatLocalTimeDate(LocalDate date, String dateFormat) {
        return (date == null || StringUtils.isBlank(dateFormat))
                ? ""
                : date.format(DateTimeFormatter.ofPattern(dateFormat));
    }

    public static Date convertDateToEndOfTheDay(final Date date) {
        if (date == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.add(Calendar.MINUTE, 59);
        calendar.add(Calendar.SECOND, 59);
        calendar.add(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
}
