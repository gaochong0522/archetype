package archetype.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class CommonUtils {

	//判断集合是否为空
	public static boolean isEmpty (List<?> list){
		if(list != null && list.size() > 0) {
			return true;
		}else {
			return false;
		}
	}
    
    public static String getDateStr() {
        return getDateStr("yyyy-MM-dd");
    }
    
    public static String getDateStr(Date date) {
        return getDateStr(date, "yyyy-MM-dd");
    }
    
	public static String getDateStr(String formate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		return sdf.format(new Date());
	}
	
	public static String getDateStr(Date date, String formate) {
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.format(date);
    }
	
	public static String getDateAdd(String date, int amount){
        return getDateAdd(date, "yyyy-MM-dd", amount);
    }
	
    public static String getDateAdd(String date, String pattern, int amount){
        return getDateAdd(date, pattern, amount, Calendar.DAY_OF_YEAR);
    }
    
    public static String getDateAdd(String date, String pattern, int amount, int field){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(date));
            calendar.add(field, amount);
            return sdf.format(calendar.getTime());
        } catch (Exception e) {
            return "";
        }
    }
    
    public static String getDateAdd(Date date, int amount){
        return getDateAdd(date, "yyyy-MM-dd", amount);
    }
    
    public static String getDateAdd(Date date, String pattern, int amount){
        return getDateAdd(date, pattern, amount, Calendar.DAY_OF_YEAR);
    }
    
    public static String getDateAdd(Date date, String pattern, int amount, int field){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(field, amount);
            return sdf.format(calendar.getTime());
        } catch (Exception e) {
            return "";
        }
    }
    
    public static Date formatDate(String date){
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
    
    public static Date formatDate(String date, String formatStr){
    	SimpleDateFormat format = new SimpleDateFormat(formatStr);
    	try {
			return format.parse(date);
		} catch (ParseException e) {
			return null;
		}
    }
	
	/**
	 * 生成随机文件名(年月日时分秒+5位随机字母/数字)
	 * @author ztb
	 * 2016-2-21 上午11:57:05
	 * @param oldFileName
	 * @return
	 */
	public static String genRandomFileName(String oldFileName){
		String ext = FilenameUtils.getExtension(oldFileName);
		return getDateStr("yyyyMMddHHmmss") + RandomStringUtils.random(5, true, true) + "." + ext;
	}
	
	public static Integer parseInt(String num){
		return parseInt(num, -1);
	}
	
	public static Integer parseInt(String num, int defaultVal){
		try {
			return Integer.parseInt(num);
		} catch (Exception e) {
			return defaultVal;
		}
	}

	public static Double parseDouble(String num){
		return parseDouble(num, -1D);
	}
	
	public static Double parseDouble(String num, double defaultVal){
		try {
			return Double.parseDouble(num);
		} catch (Exception e) {
			return defaultVal;
		}
	}
	
	
	/*
	 * 根据单号计算等级
	 */
	public static int[] getGradeDeafult(int count,int grade1,int grade2){
		int[] intArray = {count/grade1,(count%grade1)/grade2};
		return intArray;
	}
	
	/*
	 * 根据单号计算等级
	 * 默认 一级为50 二级10
	 */
	public static int[] getGrade(int count){
		return getGradeDeafult(count,50,10);
	}
	
	public static String getIp(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");  
        System.out.println(ip);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  System.out.println(ip);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  System.out.println(ip);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  System.out.println(ip);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  System.out.println(ip);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        System.out.println(ip);
        if(ip == null){
            ip= "unknown";
        }
	    return ip;
	}
	
    public static int str2int(String s, int defaultNum) {
        Integer num = defaultNum;
        try {
            if(StringUtils.isNotBlank(s)){
                num = Integer.valueOf(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }
    
    public static String getCodeStr(String maxCode) {
        return getCodeStr(maxCode, 4);
    }

    public static String getCodeStr(String maxCode, int length) {
        String newCode = null;
        int suffixInt = 0;
        //前缀
        String prefix = null;
        //后缀
        String suffix = null;
      //前缀默认为空字符串
        prefix = "";
        //后缀默认与maxTypeCode相等,当作第一级来处理
        suffix = maxCode;
        //如果不是第一级,设置前缀,截取后缀
        if(maxCode.length() > length){
            //不是第一级,取之前的作为前缀
            prefix = maxCode.substring(0, maxCode.length() - length);
            //剩下的后四位为后缀
            suffix = maxCode.substring(maxCode.length() - length);
        }
        //后缀转int并+1,再左侧用0补满4位
        suffixInt = str2int(suffix, 0);
        suffixInt++;
      //后缀=后缀int转字符串,不足四位在前面补0
        suffix = StringUtils.leftPad(String.valueOf(suffixInt), length, "0");
        
        //最终TYPE_CODE=前缀+后缀
        newCode = prefix + suffix;
        return newCode;
    }
	
    
    /**
     * @Title: formatDuring 
     * @Description: 将毫秒转换为时间字符串
     * @return String
     * @throws 
     * @author cq
     * @Date 2016-8-1 下午1:12:43
     */
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
//        long seconds = (mss % (1000 * 60)) / 1000;
        StringBuffer buffer = new StringBuffer();
        if(days != 0){
        	buffer.append(days + "天");
        }
        if(hours != 0){
        	buffer.append(hours + "小时");
        }
        if(minutes != 0){
        	buffer.append(minutes + "分钟");
        }
        
        return buffer.toString();
    }
    
    @SuppressWarnings("rawtypes")
    public static Object json2Object(String text, Class clazz) throws Exception{
        JSONObject json = JSON.parseObject(text);
        return json2Object(String.valueOf(json),clazz);
    }
    

    
    @SuppressWarnings("rawtypes")
    public static List jsonArray2List(String text, Class clazz) {
        JSONArray array = JSONArray.parseArray(text);
        return jsonArray2List(String.valueOf(array), clazz);
    }
    

}
