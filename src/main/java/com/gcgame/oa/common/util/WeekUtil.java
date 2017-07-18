package com.gcgame.oa.common.util;

import model.Week;

/**
 * Created by 高崇 on 2017/6/28.
 */
public class WeekUtil {
    public static String getWeek(int index){
        return Week.getName(index);
    }

    public static void main(String[] args) {
        System.out.println(getWeek(1));
    }
}
