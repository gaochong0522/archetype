package archetype.common.gc;

public class Unlock {
	public static void main(String[] args) {
		
	}
	public String decrypt(String data,String key){
		
		return "";
	}
}
/**
 * ϵͳ���ܷ���
 * @param  string $data 要解密的字符串 （必须是encrypt方法加密的字符串）
 * @param  string $key  加密密钥
 * @return string
 * @author winky
 */
//function decrypt($data, $key = '') {
//	$key = md5(empty($key) ? C('DATA_AUTH_KEY') : $key);
//	$data = str_replace(array('-', '_'), array('+', '/'), $data);
//	$mod4 = strlen($data) % 4;
//	if ($mod4) {
//		$data .= substr('====', $mod4);
//	}
//	$data = base64_decode($data);
//	$expire = substr($data, 0, 10);
//	$data = substr($data, 10);
//
//	if ($expire > 0 && $expire < time()) {
//		return '';
//	}
//	$x = 0;
//	$len = strlen($data);
//	$l = strlen($key);
//	$char = $str = '';
//
//	for ($i = 0; $i < $len; $i++) {
//		if ($x == $l)
//			$x = 0;
//		$char .= substr($key, $x, 1);
//		$x++;
//	}
//
//	for ($i = 0; $i < $len; $i++) {
//		if (ord(substr($data, $i, 1)) < ord(substr($char, $i, 1))) {
//			$str .= chr((ord(substr($data, $i, 1)) + 256) - ord(substr($char, $i, 1)));
//		} else {
//			$str .= chr(ord(substr($data, $i, 1)) - ord(substr($char, $i, 1)));
//		}
//	}
//	return base64_decode($str);
//}