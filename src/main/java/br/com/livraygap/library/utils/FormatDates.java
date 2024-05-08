package br.com.livraygap.library.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDates {
    public static String getDataByYearMonthDay(Date date) {
        SimpleDateFormat dateConfig = new SimpleDateFormat("dd-MM-yyyy");
        return dateConfig.format(date);
    }
}
