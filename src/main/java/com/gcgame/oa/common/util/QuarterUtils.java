package com.gcgame.oa.common.util;


import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;



public class QuarterUtils {

	/**
	 * 计算年份\季度\相对月份
	 * 
	 * @param date
	 * @return int[]<br>
	 *         下标0：年份<br>
	 *         下标1：季度（1~4）<br>
	 *         下标2：季度内相对月份（1~3）
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月22日下午5:32:40
	 */
	public static int[] calculateQuarterAndRelativeMonth(Date date) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		int currMonth = cale.get(Calendar.MONTH) + 1;
		int[] result = new int[3];
		result[0] = cale.get(Calendar.YEAR);
		result[2] = currMonth % 3 == 0 ? 3 : currMonth % 3;
		result[1] = (currMonth / 3) + (result[0] == 3 ? 0 : 1);
		return result;
	}

	/**
	 * 计算季度差（起始日期-结束日期）
	 * 
	 * @param startDate
	 *            起始日期
	 * @param endDate
	 *            结束日期
	 * @return int
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月23日下午1:09:46
	 */
	public static int calculateQuarterDifference(Date startDate, Date endDate) {
		int[] start = calculateQuarterAndRelativeMonth(startDate);
		int[] end = calculateQuarterAndRelativeMonth(endDate);
		return ((end[0] - 1) * 4 + end[1]) - ((start[0] - 1) * 4 + start[1]);
	}

	/**
	 * 获取当前季度起始、结束日期
	 * 
	 * @param date
	 * @return Date[]
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月23日下午7:09:18
	 */
	public static Date[] getQuarterStartAndEnd(int[] date) {
		FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
		Date[] resultDate = new Date[2];
		try {
			switch (date[1]) {
			case 1:
				resultDate[0] = (Date) fdf.parseObject(date[0] + "-01-01 00:00:00");
				resultDate[1] = (Date) fdf.parseObject(date[0] + "-03-31 23:59:59");
				break;
			case 2:
				resultDate[0] = (Date) fdf.parseObject(date[0] + "-04-01 00:00:00");
				resultDate[1] = (Date) fdf.parseObject(date[0] + "-06-30 23:59:59");
				break;
			case 3:
				resultDate[0] = (Date) fdf.parseObject(date[0] + "-07-01 00:00:00");
				resultDate[1] = (Date) fdf.parseObject(date[0] + "-09-30 23:59:59");
				break;
			case 4:
				resultDate[0] = (Date) fdf.parseObject(date[0] + "-10-01 00:00:00");
				resultDate[1] = (Date) fdf.parseObject(date[0] + "-12-31 23:59:59");
				break;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
	}

	/**
	 * 获取当前季度总数
	 * 
	 * @param date
	 * @return int<br>
	 *         返回当前季度总数
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月27日上午8:31:40
	 */
	public static int getCurrQuarterSum(Date date) {
		int[] yearAndQuarter = calculateQuarterAndRelativeMonth(date);
		return (yearAndQuarter[0] - 1) * 4 + yearAndQuarter[1];
	}
}
