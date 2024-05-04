package br.com.livraygap.library.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormatDates {
    public static String getDataByYearMonthDay(Date date) {
        SimpleDateFormat dateConfig = new SimpleDateFormat("dd-MM-yyyy");
        return dateConfig.format(date);
    }
}
