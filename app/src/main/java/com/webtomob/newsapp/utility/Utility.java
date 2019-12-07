package com.webtomob.newsapp.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AppCompatActivity;

import com.webtomob.newsapp.R;

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

    /**
     * @param context
     * @return true, if Internet available otherwise false
     */
    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] networkInfos = connectivity.getAllNetworkInfo();
            if (networkInfos != null)
                for (NetworkInfo info : networkInfos) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
        }
        return false;
    }

}
