package archetype.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MD5Util {    
//	private static Logger log = Logger.getLogger("MD5Util");
    /**  
    * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符  
    */    
   protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6','7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };    
   protected static MessageDigest messagedigest = null;    
   static {    
       try {    
           messagedigest = MessageDigest.getInstance("MD5");    
       } catch (NoSuchAlgorithmException e) {    
           e.printStackTrace();    
       }    
   }    
   
   public static String getFileMD5String(File file) throws IOException {    
       InputStream fis;    
       fis = new FileInputStream(file);    
       byte[] buffer = new byte[1024];    
       int numRead = 0;    
       while ((numRead = fis.read(buffer)) > 0) {    
           messagedigest.update(buffer, 0, numRead);    
       }    
       fis.close();    
       return bufferToHex(messagedigest.digest());    
   }    
     
   public static String getEncryptedPassword(String str){  
        byte[] buffer=str.getBytes();  
        messagedigest.update(buffer);  
       return bufferToHex(messagedigest.digest()).toUpperCase();  
   }  
   
   public static boolean validPassword(String password, String passwordInDb) {
	   String md5 = getEncryptedPassword(password);
	   if(md5!=null&&md5.equalsIgnoreCase(passwordInDb)){
		   return true;
	   }else{
		   return false;
	   }
   }
   
   public static String bufferToHex(byte bytes[]) {    
       return bufferToHex(bytes, 0, bytes.length);    
   }    
   
   private static String bufferToHex(byte bytes[], int m, int n) {    
       StringBuffer stringbuffer = new StringBuffer(2 * n);    
       int k = m + n;    
       for (int l = m; l < k; l++) {    
           appendHexPair(bytes[l], stringbuffer);    
       }    
       return stringbuffer.toString();    
   }    
   
   private static void appendHexPair(byte bt, StringBuffer stringbuffer) {    
       char c0 = hexDigits[(bt & 0xf0) >> 4];// 取字节中高 4 位的数字转换    
       // 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同    
       char c1 = hexDigits[bt & 0xf];// 取字节中低 4 位的数字转换    
       stringbuffer.append(c0);    
       stringbuffer.append(c1);    
   } 
 public static void main(String[] args) {
	 //String str ="src.main.java.com.zmtech.uxgou.model.user.java";
	 String str ="dddabcdddxyz";
    // Pattern pattern = Pattern.compile("(.*)zmtech(.*)uxgou(.*)^(ucenter)(.*)");
     Pattern pattern = Pattern.compile("(abc)[^((?!xyz).)*$]\\g",Pattern.DOTALL);
     Matcher matcher = pattern.matcher(str);
     int c = matcher.groupCount();
     while(matcher.find()) {
    	 for(int i=1;i<=c;i++){
    		 System.out.println(i+"==="+matcher.group(i));
    	 }
         
     }       
 }
	
}    