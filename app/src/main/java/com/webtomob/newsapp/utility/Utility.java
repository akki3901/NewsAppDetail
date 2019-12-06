package com.webtomob.newsapp.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static String changeDateFormat(String dateString) { //2014-10-31T17:40:41-04:00
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss-hh:mm");
        SimpleDateFormat formatNew = new SimpleDateFormat("dd MMM, yyyy");
        Date date = null;
        String newDateString = "";
        if (dateString.length() > 0) {
            try {
                date = format.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            newDateString = formatNew.format(date);
        }
        return newDateString;
    }
}
