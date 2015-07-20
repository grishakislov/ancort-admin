package com.mttch.admin.server.utils;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtils {

    public static String unixTimestampToDate(long seconds) {
        if (seconds == 0) {
            return "0";
        }
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"));
        DateFormat format = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.GERMAN);
        format.setCalendar(c);
        return format.format(seconds * 1000);
    }

    public static long getUnixSeconds() {
        return Instant.now().getEpochSecond();
    }

    public static long getNowMillis() {
        return System.currentTimeMillis();
    }

    public static int secondsToDays(long seconds) {
        return (int) seconds / 86400;
    }

    public static long daysToSeconds(int days) {
        return days * 86400;
    }


    public static long future(int sessionExpireSeconds) {
        return getUnixSeconds() + sessionExpireSeconds;
    }

    public static boolean isPast(long timeStamp) {
        return getUnixSeconds() > timeStamp;
    }
}
