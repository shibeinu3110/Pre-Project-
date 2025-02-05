package com.example.l3.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateHelper {

    public static final String DATE_SLASH = "dd/MM/yyyy";
    public static final String DATE_TIME = "yyyyMMdd HH:mm:ss";

    public static final String DB_DATE = "yyyyMMdd";
    public static final String DB_DATE_TIME = "yyyyMMddHHmmss";
    public static final String GLOBAL_DATE = "yyyy-MM-dd";
    public static final String GLOBAL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static String toDateSlash(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_SLASH);
        return simpleDateFormat.format(date.getTime());
    }

    public static String toDateSlash(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_SLASH);
        return localDate.format(formatter);
    }

    public static String toDateTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME);
        return simpleDateFormat.format(date.getTime());
    }

    public static String toDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME);
        return localDateTime.format(formatter);
    }

    public static String toDbDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DB_DATE);
        return simpleDateFormat.format(date.getTime());
    }

    public static String toDbDate(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DB_DATE);
        return localDate.format(formatter);
    }

    public static String toDbDateTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DB_DATE_TIME);
        return simpleDateFormat.format(date.getTime());
    }

    public static String toDbDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DB_DATE_TIME);
        return localDateTime.format(formatter);
    }

    public static String toGlobalDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(GLOBAL_DATE);
        return simpleDateFormat.format(date.getTime());
    }

    public static String toGlobalDate(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GLOBAL_DATE);
        return localDate.format(formatter);
    }

    public static String toGlobalDateTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(GLOBAL_DATE_TIME);
        return simpleDateFormat.format(date.getTime());
    }

    public static String toGlobalDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GLOBAL_DATE_TIME);
        return localDateTime.format(formatter);
    }

    public static LocalDate toLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static LocalDate fromDateSlash(String dateSlash) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_SLASH);
        return LocalDate.parse(dateSlash, formatter);
    }

    public static LocalDateTime fromDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME);
        return LocalDateTime.parse(dateTime, formatter);
    }

    public static LocalDate fromDbDate(String dbDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DB_DATE);
        return LocalDate.parse(dbDate, formatter);
    }

    public static LocalDateTime fromDbDateTime(String dbDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DB_DATE_TIME);
        return LocalDateTime.parse(dbDateTime, formatter);
    }

    public static LocalDate fromGlobalDate(String globalDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GLOBAL_DATE);
        return LocalDate.parse(globalDate, formatter);
    }

    public static LocalDateTime fromGlobalDateTime(String globalDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GLOBAL_DATE_TIME);
        return LocalDateTime.parse(globalDateTime, formatter);
    }
}

