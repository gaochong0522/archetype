package com.gcgame.oa.common.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.FastDateFormat;

/**
 * java日期操作工具类
 *
 */
public class DateUtils {
	private static SimpleDateFormat monthNumberFormate = new SimpleDateFormat("yyyyMM");
	
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 获取考核月份
	 * @date 2017-2-23上午8:46:04
	 */
	public static Integer getMonthNo(Date date){
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		if(now.get(Calendar.DAY_OF_MONTH)>=21){
			now.add(Calendar.MONTH, 1);
		}
		return Integer.parseInt(monthNumberFormate.format(now.getTime())) ;
	}
	
	public static Integer getMonth(Date date){
		Calendar now = Calendar.getInstance();
		return Integer.parseInt(monthNumberFormate.format(now.getTime())) ;
	}
	
	public static Date getStartDate(int month) {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.YEAR,(int) (month/100));
		now.set(Calendar.MONTH,(int) (month%100)-2);
		now.set(Calendar.DAY_OF_MONTH, 21);
		return now.getTime();
	}
	/**
	 * 获取上个月的月初
	 * @author Hs
	 * @date 2017-4-18 下午6:39:53
	 * @Description: TODO
	 */
	public static Date getLastMonthDay(){
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.add(Calendar.MONTH,-1);
		return now.getTime();
		
	}
	
	/**
	 * 获取开始时间yyyy-MM-dd HH:mm:ss格式字符串
	 * @author ztb
	 * 2014年8月26日 下午2:31:14
	 * @param month
	 * @return
	 */
	public static String getStartDateStr(int month){
		return dateTimeFormat.format(getStartDate(month));
	}
	
	public static Date getEndDate(int month) {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.YEAR,(int) (month/100));
		now.set(Calendar.MONTH,(int) (month%100)-1);
		now.set(Calendar.DAY_OF_MONTH, 21);
		return now.getTime();
	}
	
	/**
	 * 获取结束时间yyyy-MM-dd HH:mm:ss格式字符串
	 * @author ztb
	 * 2014年8月26日 下午2:31:55
	 * @param month
	 * @return
	 */
	public static String getEndDateStr(int month){
		return dateTimeFormat.format(getEndDate(month));
	}
	/**
	 * 将字符串转换成日期
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date stringToDate(String dateStr,String formatStr){
		DateFormat dd=new SimpleDateFormat(formatStr);
		Date date=null;
		try {
			date = dd.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/*
	 * 获取上周一
	 */
	public static String getLastMonday(){
		    String monday="";
		    Calendar cal = Calendar.getInstance();
		    cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
		    cal.add(Calendar.DATE, -1*7);
		    cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
		    String   monday1 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		    monday=   monday1+" 00:00:00";	
		return monday;
	}
	/*
	 * 获取上周日
	 */
	public static String getLastSunday(){
		String  sunday="";
	    Calendar cal = Calendar.getInstance();
	    cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
	    cal.add(Calendar.DATE, -1*7);
	    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	    String    sunday1 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	    sunday=sunday1+" 00:00:00";
		return sunday;
	}
	/*
	 * 获取本周一
	 */
	 public static String getThisMonday() {
		  Calendar cal = Calendar.getInstance();
		  int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		  if (day_of_week == 0)day_of_week = 7;
		  cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.add(Calendar.DATE, -day_of_week + 1);
		  String monday="";
		  monday = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
		  return monday;
		 }
	
	/*
	 * 获取本周日
	 */
	public static String getThisSunday(){
		      String sunday="";
			  Calendar c = Calendar.getInstance();
			  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
			  if (day_of_week == 0)
			  day_of_week = 7;
			  c.add(Calendar.DATE, -day_of_week + 7);
			  sunday = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(c.getTime());
		return sunday;
	}
	
	/**
	 * 获取当前日期和相差days天的日期（yyyy-MM-dd）
	 * 
	 * @param days 天数
	 * 
	 * @return Date数组，0为当前日期，1为当前日期减days天的日期
	 * 
	 * @author lmj
	 */
	public static Date[]  getDateByDays(int days){
		Date[] dateArr = new Date[2];
		Date beginDate = new Date();
		dateArr[0] = beginDate;
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - days);
		try {
			dateArr[1] = dateFormat.parse(dateFormat.format(date.getTime()));
			return dateArr;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取给定时间的年分
	 * 
	 * @param date
	 * 
	 * @return int
	 *  
	 * @author lmj
	 */
	public static int  getYear(Date targerDate){
		Calendar date = Calendar.getInstance();
		date.setTime(targerDate);
		return date.get(Calendar.YEAR);
	}
	
	/**
	 * 获取当前日期（不带时分秒）
	 * 
	 * @return String
	 * 
	 * @author lmj
	 */
	public static Date getNow(){
		Date now;
		try {
			now = dateFormat.parse(dateFormat.format(new Date()));
			return now;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *将日期格式化成字符串
	 * 
	 * @param date
	 * 
	 * @return String 
	 *
	 *current time:2017-3-3
	 *
	 *@author 李明俊
	 */
	public static String getStrDate(Date date){
		return dateFormat.format(date);
	}
	
	/**
	 *计算两个日期相差的天数
	 * 
	 * @param startDate 较小的日期
	 * 
	 * @param endDate 较大的日期
	 * 
	 * @return Date 
	 *
	 *current time:2017-3-1
	 *
	 *@author 李明俊
	 */
	public static int getBetweenDays(Date startDate,Date endDate){
		return (int)((endDate.getTime() - startDate.getTime())/(24 * 60 * 60 * 1000));
	}
	
	/**
	 * 取上个月的21号
	 * @author hql
	 * @date 2017-2-22下午3:58:00
	 */
	public static String getFirstDayOfLastMonth(int year,int month)
	  {
	    Calendar cal = Calendar.getInstance();
	    //设置年份
	    cal.set(Calendar.YEAR,year);
	    //设置月份
	    cal.set(Calendar.MONTH, month-1);
	    //设置日历中月份的第1天
	    cal.set(Calendar.DAY_OF_MONTH, 21);
	    //格式化日期
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String firstDayOfMonth = sdf.format(cal.getTime());
	    
	    return firstDayOfMonth ;
	  }
	/**
	 * 获取上个月的最后一天
	 * @author hql
	 * @date 2017-2-22下午3:58:00
	 */
	public static String getLastDayOfLastMonth(int year,int month)
	  {
	    Calendar cal = Calendar.getInstance();
	    //设置年份
	    cal.set(Calendar.YEAR,year);
	    //设置月份
	    cal.set(Calendar.MONTH, month);
	    //设置日历中月份的第1天
	    cal.set(Calendar.DAY_OF_MONTH, 0);
	    //格式化日期
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String firstDayOfMonth = sdf.format(cal.getTime());
	    
	    return firstDayOfMonth ;
	  }
	/**
	 * 获取当前月的20号
	 * @author hql
	 * @date 2017-2-22下午3:58:00
	 */
	public static String getLastDayOfThisMonth(int year,int month)
	  {
	    Calendar cal = Calendar.getInstance();
	    //设置年份
	    cal.set(Calendar.YEAR,year);
	    //设置月份
	    cal.set(Calendar.MONTH, month);
	    //设置日历中月份的第1天
	    cal.set(Calendar.DAY_OF_MONTH, 20);
	    //格式化日期
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String firstDayOfMonth = sdf.format(cal.getTime());
	    //DateUtils.
	    return firstDayOfMonth ;
	  }
	/**
	 * 获取当前月月初
	 * @author hql
	 * @date 2017-2-22下午3:58:00
	 */
	public static String getFistDayOfThisMonth(int year,int month)
	  {
	    Calendar cal = Calendar.getInstance();
	    //设置年份
	    cal.set(Calendar.YEAR,year);
	    //设置月份
	    cal.set(Calendar.MONTH, month);
	    //设置日历中月份的第1天
	    cal.set(Calendar.DAY_OF_MONTH, 1);
	    //格式化日期
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String firstDayOfMonth = sdf.format(cal.getTime());
	    //DateUtils.
	    return firstDayOfMonth ;
	  }
	/**
	 * 根据考核时间返回时间的list 例如2017-01-21 2017-02-20
	 * @author hql
	 * @date 2017-2-22下午5:16:10
	 */
	public static List<String> daysBettwen(String FirstDayOfLastMonth,String LastDayOfLastMonth,String FistDayOfThisMonth,String LastDayOfThisMonth){
		List<String>  list=new  ArrayList<String>();
		//String  first="2017-01-21";
		//String  first="2017-02-01";
		//String  last="2017-01-31";
		//String  last="2017-02-20";
		//DateUtils.getFragmentInDays(date, fragment)
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		long nd = 1000*24*60*60;//一天的毫秒数
		//获得两个时间的毫秒时间差异
		try {
			/* **********************上个月的*********************/
			//long diff = sd.parse(last).getTime() - sd.parse(first).getTime();
			long diff = sd.parse(LastDayOfLastMonth).getTime() - sd.parse(FirstDayOfLastMonth).getTime();
			long day =diff/nd;//差的天数
			String temp="";
			for (long i = 0; i <= day; i++) {
				temp=FirstDayOfLastMonth.substring(0,8)+""+(21+i);
				list.add(temp);
				//map.put(temp, temp);
			}
			/* ******************当月的 ************************/
			long diffThis = sd.parse(LastDayOfThisMonth).getTime() - sd.parse(FistDayOfThisMonth).getTime();
			long dayThis =diffThis/nd;//差的天数
			String tempThis="";
			for (long i = 0; i <= dayThis; i++) {
				if(i<=8){
					tempThis=FistDayOfThisMonth.substring(0,8)+"0"+(1+i);
				}else{
					tempThis=FistDayOfThisMonth.substring(0,8)+""+(1+i);	
				}
				//temp=first.substring(0,8)+""+(21+i);
				list.add(tempThis);
				//map.put(temp, temp);
			}
			//list.add(map);
			return list;
		} catch (ParseException e) {
			e.printStackTrace();
			
			return null;
		}
	}
	public static Map<String,String> getMeetingCheckTime(Date date){
		Map<String,String> map = new HashMap<String,String>();
		Calendar now = Calendar.getInstance();
		now.setTime(date);
			now.add(Calendar.MINUTE, -15);
			map.put("startTime", FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss").format(now.getTime()));
			now.add(Calendar.MINUTE, +45);
			map.put("endTime", FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss").format(now.getTime()));
		return map;
	}
	/**
	 * 算工齡
	 * @author hql
	 * @date 2017-3-11下午4:53:54
	 */
	public static int getWorkingYears(Date entryTime) {
		int workingYears = -1;
		if (entryTime == null) {// 沒填入職時間的,顯示為-
			return workingYears;
		}
		try {
			String _entryTime = FastDateFormat.getInstance("yyyy").format(
					entryTime);
			String nowTime = FastDateFormat.getInstance("yyyy").format(
					new Date());
			workingYears = Integer.parseInt(nowTime)
					- Integer.parseInt(_entryTime);
		} catch (NumberFormatException e) {
			workingYears = -1;
			e.printStackTrace();
		}
		// System.out.println(_entryTime);
		return workingYears;
	}
	/**
	 * 返回季度的list
	 * @author hql
	 * @date 2017-3-12下午6:15:18
	 */
	public static List<Integer> getQuarterList(String quarter) {
		List<Integer> quarterList = new ArrayList<Integer>();
		if("04".equals(quarter)||"05".equals(quarter)||"06".equals(quarter)){
			quarterList.add(Integer.parseInt((FastDateFormat.getInstance("yyyy").format(new Date())+"01")));
			quarterList.add(Integer.parseInt((FastDateFormat.getInstance("yyyy").format(new Date())+"02")));
			quarterList.add(Integer.parseInt((FastDateFormat.getInstance("yyyy").format(new Date())+"03")));
		}else if("07".equals(quarter)||"08".equals(quarter)||"09".equals(quarter)){
		//case "7,8,9":
			quarterList.add(Integer.parseInt((FastDateFormat.getInstance("yyyy").format(new Date())+"04")));
			quarterList.add(Integer.parseInt((FastDateFormat.getInstance("yyyy").format(new Date())+"05")));
			quarterList.add(Integer.parseInt((FastDateFormat.getInstance("yyyy").format(new Date())+"06")));
		}else if("10".equals(quarter)||"11".equals(quarter)||"12".equals(quarter)){	//break;
		//case "10,11,12":
			quarterList.add(Integer.parseInt((FastDateFormat.getInstance("yyyy").format(new Date())+"07")));
			quarterList.add(Integer.parseInt((FastDateFormat.getInstance("yyyy").format(new Date())+"08")));
			quarterList.add(Integer.parseInt((FastDateFormat.getInstance("yyyy").format(new Date())+"09")));
		//	break;
		}else if("01".equals(quarter)||"02".equals(quarter)||"03".equals(quarter)){
			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.YEAR, -1);
	        Date y = cal.getTime();
	        String year = format.format(y);
	       // System.out.println("过去一年："+year);
			quarterList.add(Integer.parseInt(year+"10"));
			quarterList.add(Integer.parseInt(year+"11"));
			quarterList.add(Integer.parseInt(year+"12"));
//			break;
//		default:
//			break;
		}
		return quarterList;
	}
	/**
	 * 判断是否是关键时间段
	 * @author hql
	 * @date 2017-3-15下午12:21:19
	 */
	public  static boolean isKeyTime(Date date){
		//String hour=FastDateFormat.getInstance("HH").format(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//int hour = cal.get(Calendar.HOUR_OF_DAY);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		if(hour >= 7 && hour < 9){
			return true;
		}else if(hour >=11&&hour<13){
			return true;
		}else if(hour>=17&&hour<19){
			return true;
		}else if((hour>=0&&hour<5)
				||(hour == 5 && minute <= 30)){
			return true;
		}
		return false;
	}
	/**
	 * 安全问题的关键时段
	 * @Description: TODO
	 * @author hql
	 * @date 2017-3-15下午2:58:34
	 */
	public  static boolean anQuanIsKeyTime(Date date){
		//String hour=FastDateFormat.getInstance("HH").format(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//int hour = cal.get(Calendar.HOUR_OF_DAY);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if(hour >=11&&hour<13){
			return true;
		}
		return false;
	}
	
}