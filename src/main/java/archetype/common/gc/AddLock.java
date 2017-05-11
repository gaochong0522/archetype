package archetype.common.gc;

import java.util.Date;

import archetype.common.utils.Base64;
import archetype.common.utils.MD5Util;


public class AddLock {
	public static void main(String[] args) {
		AddLock addLock=new AddLock();
		System.out.println(String.format("%010d", 5551));
		System.out.println(addLock.encrypt("636234", "1", 30));
	
	}
	/**
	 * 
	 * @param data 要加密的字符串
	 * @param key	加密密钥
	 * @param expire 过期时间
	 * @return
	 */
	public String encrypt(String data,String key,int expire){
		String keyl= MD5Util.getEncryptedPassword(key==null?"DATA_AUTH_KEY":key);
		String bdata=Base64.encode(data.getBytes()).toString();
		int x=0;
		int len=bdata.length();
		int l=key.length();
		char c=' ';
		String c1="";
		for (int i = 0; i < len; i++) {
			if (x==l) {
				x=0;
			}
			c1 +=keyl.substring(0, 1);
			x++;
		}
		expire=expire+(int)(new Date().getTime()/1000);
		String str=String.format("%010d", expire);
		for (int i = 0; i < len; i++) {
			str +=String.valueOf((char)((int)bdata.substring(i).charAt(0)+((int)c1.substring(i).charAt(0)))%256);
		}
		return Base64.encode(str.getBytes()).toString().replace('+', '-').replace('/', '_').replace('=', ' ');
	}
	public static int stringToAscii(String value)  
	{  
	    StringBuffer sbu = new StringBuffer();  
	    char[] chars = value.toCharArray();   
	    for (int i = 0; i < chars.length; i++) {  
	        if(i != chars.length - 1)  
	        {  
	            sbu.append((int)chars[i]);  
	        }  
	        else {  
	            sbu.append((int)chars[i]);  
	        }  
	    }  
	    return Integer.parseInt(sbu.toString());  
	}  
	public static void t1(){//ASCII转换为字符串

		  String s="22307 35806 24555 20048";//ASCII码

		  String[]chars=s.split(" ");
		  System.out.println("ASCII 汉字 \n----------------------");
		        for(int i=0;i<chars.length;i++){ 
		            System.out.println(chars[i]+" "+(char)Integer.parseInt(chars[i]));
		        } 
		 }
		 public static void t2(){//字符串转换为ASCII码

		  String s="[新年快乐！]";//字符串

		  char[]chars=s.toCharArray(); //把字符中转换为字符数组 

		  System.out.println("\n\n汉字 ASCII\n----------------------");
		  for(int i=0;i<chars.length;i++){//输出结果

		         System.out.println(" "+chars[i]+" "+(int)chars[i]);
		        }
		 }
		
}
//function encrypt($data, $key = '', $expire = 0) {
//	$key = md5(empty($key) ? C('DATA_AUTH_KEY') : $key);
//	$data = base64_encode($data);
//	$x = 0;
//	$len = strlen($data);
//	$l = strlen($key);
//	$char = '';
//
//	for ($i = 0; $i < $len; $i++) {
//		if ($x == $l)
//			$x = 0;
//		$char .= substr($key, $x, 1);
//		$x++;
//	}
//
//	$str = sprintf('%010d', $expire ? $expire + time() : 0);
//
//	for ($i = 0; $i < $len; $i++) {
//		$str .= chr(ord(substr($data, $i, 1)) + (ord(substr($char, $i, 1))) % 256);
//	}
//	return str_replace(array('+', '/', '='), array('-', '_', ''), base64_encode($str));
//}

