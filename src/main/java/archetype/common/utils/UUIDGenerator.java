package archetype.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDGenerator {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    public UUIDGenerator() {
    }

    public static String getUUID() {
     UUID uuid = UUID.randomUUID();
     String str = uuid.toString();
     // 去掉"-"符号
//     String temp = str.replace("-", "").toUpperCase();
//     return temp;
     return str;
    }
    
    /**
     * 生成订单号（以时间为基础）
     * format yyyyMMddHHmmss
     * @return
     */
    public static String getDateUUID() {
    	return sdf.format(new Date());
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(UUIDGenerator.getUUID());
    }



}
