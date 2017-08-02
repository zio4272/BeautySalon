package kr.co.tjeit.beautysalon.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by the on 2017-07-27.
 */

public class DateTimeUtil {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 M월 d일");
    static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    // 2017년 10월 25일
    static SimpleDateFormat timeFormat = new SimpleDateFormat("a hh:mm");

    // 날짜와 시간을 돌려주는 메쏘드 / 날짜포멧변수
    // 2017-10-08 오전 8:10
    // 완성하면, 직원로그인 해서 나타나는 화면에 날짜시간을 모두 찍어주자.
    static SimpleDateFormat totFormat = new SimpleDateFormat("yyyy-MM-d a h:mm");

    public static String getTotString(Calendar totCal) {
        String str = totFormat.format(totCal.getTime());
        return str;
    }

    public static String getDateString(Calendar dateCal) {
        String str = dateFormat.format(dateCal.getTime());
        return str;
    }

    public static String getDateString2(Calendar dateCal) {
        String str = dateFormat2.format(dateCal.getTime());
        return str;
    }

    public static String getTimeString(Calendar timeCal) {
        String str = timeFormat.format(timeCal.getTime());
        return str;


    }

}
