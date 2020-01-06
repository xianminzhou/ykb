package com.seecen.dd.xxxsys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderDateUtil {

    /*修改正确日期格式*/
    public static String DateChange(String time){
        StringBuilder sb = new StringBuilder();
        String year = time.substring(time.length()-4);   //截取年份
        sb.append(year);
        sb.append("-");
        String month = time.substring(0,2);
        sb.append(month);
        sb.append("-");//截取月份
        String day = time.substring(3,5);
        sb.append(day);
        return sb.toString();
    }


    /*修改日期格式*/
    public static Date DateYmd(String time){
        SimpleDateFormat myFormatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date date = null;
        try {
            date = myFormatter.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*随机流水号*/
    public static Integer orderNumber(){
        String num = "";
        for (int j = 0; j <3 ; j++) {
            int i = (int) (Math.random() * 10);
            num = num+i;
        }
        String time = System.currentTimeMillis()+"";
        String substring = time.substring(10, 13);
        substring=substring+num;
        int i = Integer.parseInt(substring);
        return i;
    }
}
