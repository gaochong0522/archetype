package com.gcgame.oa.common.dwr;

import java.util.HashSet;
import java.util.Set;

public class Test {
	private int i;
	private String s;
	
	
	
	public String getS() {
		return s;
	}


	public void setS(String s) {
		this.s = s;
	}


	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}

	public int hashCode() {
		return i % 10;
	}

	public boolean equals(Object obj) {
		if(obj == null) {//验证非null
			return false;
		}
		if(obj == this) {//自反性 对于任何非null的引用值x，x.equals(x)必须返回true
			return true;
		}
		if(!(obj instanceof Test)) {
			return false;
		}
		Test tt = (Test)(obj);
		if(tt.getI() == this.getI()) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String ss = "123";
//		String sss = "1234";
//		ss.equals(sss);
		String s1 = new String("1");
		String s2 = "1";
		System.out.println(s2);
		System.out.println(s1.toCharArray().length + "  " + s1);
		
		Test t1 = new Test();
		Test t2 = new Test();
		t1.setI(12);
		t2.setI(12);
		System.out.println(t1);//打印对象的地址 类路径@哈希值
		System.out.println(t2);
		System.out.println(t1.equals(t2));
		Set<Test> s = new HashSet<Test>();
		s.add(t1);
		s.add(t2);
		System.out.println(s);//打印存放的集合，可以看出仍然是两个对象，应为equals方法没有覆盖
		for(Test t : s) {
			System.out.println("i==" + t.getI());
		}
	}

}
