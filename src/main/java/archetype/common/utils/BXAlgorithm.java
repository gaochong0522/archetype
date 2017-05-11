package archetype.common.utils;

public class BXAlgorithm {
	private static int registration_residence = 80;
	private static int registration_not_residence = 550;
	private static double litigation_proportion = 0.7; //诉讼费比例
	/**
	 * 诉讼费
	 * @param value
	 * @return
	 */
	public static int getSuSong(int value){  //value评估总值
		double a =  (value * litigation_proportion);
		double b = 0;
		int c= 0;
		if (a > 20000000) {
			b=(a*0.005)+41800;
		}else if (a>10000000&&a<=20000000) {
			b=(a*0.006)+21800;
		}else if (a>5000000&&a<=10000000) {
			b=(a*0.007)+11800;
		}else if (a>2000000&&a<=5000000) {
			b=(a*0.008)+6800;
		}else if (a>500000&&a<=1000000) {
			b=(a*0.01)+3800;
		}else if (a>200000&&a<=500000) {
			b=(a*0.015)+1300;
		}else if (a>100000&&a<=200000) {
			b=(a*0.02)+300;
		}else if (a>10000&&a<=100000) {
			b=(a*0.025)-200;
		}else {
			b = 50;
		}
		return (int)Math.round(b);
	}
	/**
	 * 执行费
	 * @param value
	 * @return
	 */
	public static int execution(int value){
		double a = value * litigation_proportion;
		double b = 0;
		if (a>10000000) {
			b=a*0.001+67400;
		} else if(a>5000000&&a<=10000000){
			 b=a*0.005+27400;
		}else if (a>500000&&a<=5000000) {
			b=a*0.01+2400;
		}else if ( a<=500000) {
			b=a*0.015-100;
		}else {
			b=0;
		}
			return (int)Math.round(b);
	}
	/**
	 * 保全费
	 * @param value
	 * @return
	 */
	public static int preservation(int value){
		double a = value * litigation_proportion;
		double b = 0;
		if (a>896000) {
			b=5000;
		}else if (a>100000&&a<=896000) {
			b=a*0.005+520;
		}else if (a>1000&&a<=100000) {
			b=a*0.01+20;
		}else if (a<=1000) {
			b=30;
		}else {
			b=0;
		}
		return (int)Math.round(b);
	}
	/**
	 * 评估费
	 * @param value
	 * @return
	 */
	public static int assessment(int value){
		double a = value * litigation_proportion;
		double b = 0;
		if (a>100000000) {
			b=(a-100000000)*0.0001+82500;
		}else if (a>80000000&&a<=100000000) {
			b=(a-80000000)*0.0002+78500;
		}else if (a>50000000&&a<=80000000) {
			b=(a-50000000)*0.0004+62500;;
		}else if (a>20000000&&a<=50000000) {
			b=(a-20000000)*0.0008+42500;
		}else if (a>10000000&&a<=20000000) {
			b=(a-10000000)*0.0015+27500;
		}else if (a>1000000&&a<=10000000) {
			b=(a-1000000)*0.0025+5000;
		}else if (a<1000000) {
			b=a*0.005;
		}else {
			b=0;
		}
		return (int)Math.round(b);
	}
	/**
	 * 拍卖费
	 * @param value
	 * @return
	 */
	public static int auction(int value){
		return (int)(value*0.01);
	}
	/**
	 * 交易手续费
	 * @param value
	 * @return
	 */
	public static int transaction(int value,String residence,double area){
//		if (residence.equals("住宅")||residence.equals("普通住宅")) {
//			return (int)Math.round(area*4);
//		}else {
//			return (int)(value*0.007*0.5);
//		}
		return 0;
	}
	/**
	 * 增值税
	 */
	public static int valueaddedtax(int value){
		double a= value/1.05*0.05*1.12;
		return (int)Math.round(a);
	}
	/**
	 * 印花税
	 */
	public static int stamptax(int value){
		double a=value*0.005;
		return (int)Math.round(a);
	}
	/**
	 * 登记费
	 */
	public static int registration(String residence){
		if (residence.equals("住宅")||residence.equals("普通住宅")) {
			return registration_residence;
		}else {
			return registration_not_residence;
		}
	}
	/**
	 * 合计
	 */
	public static int getAll(int value){
		return stamptax(value)+valueaddedtax(value)+auction(value)+assessment(value)+preservation(value)+execution(value)+getSuSong(value);
	}
}
