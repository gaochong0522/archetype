package archetype.common.utils;

public class ParseUtils {

	/**
	 * String to long
	 * @author ztb
	 * 2014年8月3日 上午10:15:58
	 * @param data
	 * @return
	 */
	public static long str2long(String data){
		return str2long(data, -1L);
	}
	
	/**
	 * String to long
	 * @author ztb
	 * 2014年8月3日 上午10:16:13
	 * @param data
	 * @param defaultVal
	 * @return
	 */
	public static long str2long(String data, long defaultVal){
		try {
			return Long.parseLong(data);
		} catch (Exception e) {
			return defaultVal;
		}
	}
	
	public static int str2int(String data){
		return str2int(data, -1);
	}
	
	public static int str2int(String data, int defaultVal){
		try {
			return Integer.parseInt(data);
		} catch (Exception e) {
			return defaultVal;
		}
	}
}
