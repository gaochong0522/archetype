package com.gcgame.oa.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 星期工具类
 * 
 * @author 刘旭 (LiuXu)
 * 
 *         2017年2月13日下午12:59:48
 * 
 */
public class WeekUtils {

	/**
	 * 根据日期计算星期（依据蔡勒公式计算）
	 * 
	 * 蔡勒公式只适合于1582年（中国明朝万历十年）10月15日之后的情形
	 * 
	 * @param y
	 * @param m
	 * @param d
	 * 
	 * @return int<br>
	 *         返回值为0~6,0代表星期日
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月13日下午1:34:05
	 */
	public static int calculateWeekByDate(int y, int m, int d) {
		// 蔡勒公式：w=y+[y/4]+[c/4]-2c+[26(m+1)/10]+d-1
		// 公式中的符号含义如下，
		// w：星期；
		// c：世纪-1；
		// y：年（两位数）；
		// m：月（m大于等于3，小于等于14，即在蔡勒公式中，某年的1、2月要看作上一年的13、14月来计算，比如2003年1月1日要看作2002年的13月1日来计算）；
		// d：日；[ ]代表取整，即只要整数部分。(C是世纪数减一，y是年份后两位，M是月份，d是日数。1月和2月要按上一年的13月和
		// 14月来算，这时C和y均按上一年取值。)
		y = y % 100;
		if (m < 3) {
			y -= 1;
			m += 12;
		}
		// c计算
		int c = 0;
		if (y / 100.00 > 0) {
			c = c / 100;
		} else {
			c = c / 100 - 1;
		}
		// W%7，余数是几就是星期几,0代表星期日
		int w = y + (y / 4) + (c / 4) - (2 * c) + (26 * (m + 1) / 10) + d - 1;
		return w % 7;
	}

	/**
	 * 根据日期计算星期（依据蔡勒公式计算）
	 * 
	 * 蔡勒公式只适合于1582年（中国明朝万历十年）10月15日之后的情形
	 * 
	 * @param date
	 * @return int<br>
	 *         返回值为0~6,0代表星期日
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月19日上午11:12:03
	 */
	public static int calculateWeekByDate(Date date) {
		int[] intArray = formatDateToIntArray(date);
		return calculateWeekByDate(intArray[0], intArray[1], intArray[2]);
	}

	/**
	 * 日期格式化为int型数组
	 * 
	 * @param date
	 * @return int[]
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月19日上午9:19:08
	 */
	public static int[] formatDateToIntArray(Date date) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		int[] dateArray = new int[6];
		dateArray[0] = cale.get(Calendar.YEAR);
		dateArray[1] = cale.get(Calendar.MONTH) + 1;
		dateArray[2] = cale.get(Calendar.DAY_OF_MONTH);
		dateArray[3] = cale.get(Calendar.HOUR_OF_DAY);
		dateArray[4] = cale.get(Calendar.MINUTE);
		dateArray[5] = cale.get(Calendar.SECOND);
		return dateArray;
	}

	/**
	 * 计算周内任意星期的日期
	 * 
	 * @param referenceDate
	 *            参考日期
	 *            周起始设置（通常周日or周一）<br>
	 *            [参数值0~6,0代表星期日]
	 * @param tagetWeek
	 *            [参数值0~6,0代表星期日]
	 * @return Date
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月19日上午11:13:25
	 */
	public static Date calculateWeekInnerDate(Date referenceDate, int weekStart, int tagetWeek) {
		// 计算出参考日期星期
		int referenceWeek = calculateWeekByDate(referenceDate);
		// 计算出对应星期为一周的第几天
		int[] dayOfWeek = new int[2];
		for (int i = 0; i < 7 && (dayOfWeek[0] == 0 || dayOfWeek[1] == 0); i++) {
			if (weekStart > 6) {
				weekStart = 0;
			}
			// 参考星期在一周的第几天
			if ((weekStart++) == referenceWeek) {
				dayOfWeek[0] = i + 1;
			}
			// 目标星期在一周的第几天
			if ((weekStart - 1) == tagetWeek) {
				dayOfWeek[1] = i + 1;
			}
		}
		// 根据参考日期计算出本周内任意日期
		return calculateDates(referenceDate, dayOfWeek[1] - dayOfWeek[0]);
	}

	/**
	 * 计算日期
	 * 
	 * @param initialDate
	 *            初始日期
	 * @param span
	 *            日期跨度（单位：天，可以为负）
	 * @return Date
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月19日下午3:21:17
	 */
	public static Date calculateDates(Date initialDate, int span) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(initialDate);
		cale.add(Calendar.DATE, span);
		return cale.getTime();
	}
}
