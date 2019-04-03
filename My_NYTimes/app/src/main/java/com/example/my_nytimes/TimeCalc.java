package com.example.my_nytimes;

import android.annotation.SuppressLint;

import java.util.Date;

public class TimeCalc {
    public static String calculateDifferentToString(Date timeMoment){
        return CheckTime(
                timeMoment.getTime() - System.currentTimeMillis(),
                timeMoment
        );
    }

    @SuppressLint("DefaultLocale")
    private static String CheckTime(long time, Date timeMoment){
        if (time > (long) 1.7e+07){
            return timeMoment.toString();
        }else{
            String output = "";

            if (time >= (long) 3.6e+06){
                int count = (int) (time/((long) 3.6e+06));

                output = String.
                        format("%d hour%s ago",
                                count,
                                (count == 1)?"s":"");
            }else if (time >= 60000L){
                int count = (int) (time/60000L);

                output = String.
                        format("%d minute%s ago",
                                count,
                                (count == 1)?"s":"");
            }else if (time >= 1000L){
                int count = (int) (time/1000L);

                output = String.
                        format("%d second%s ago",
                                count,
                                (count == 1)?"s":"");
            }
            return output;
        }
    }
}
