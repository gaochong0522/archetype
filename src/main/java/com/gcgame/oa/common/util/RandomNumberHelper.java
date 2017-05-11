package com.gcgame.oa.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberHelper {
	private static Random random = new Random();
	
	public static List<Integer> RandomSelect(List<Integer> sourceList, int selectCount)
	{
		if (selectCount > sourceList.size()){
			try {
				throw new Exception("selectCount必需大于sourceList.Count");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < selectCount; i++)
		{
		int nextIndex = GetRandomNumber(sourceList.size()-1);
		int nextNumber = sourceList.get(nextIndex);
		sourceList.remove(nextIndex);
		resultList.add(nextNumber);
		}
		return resultList;
	}
	public static int GetRandomNumber(int n)
	{
		return random.nextInt(n);
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(16);
		list.add(17);
		list.add(18);
		list.add(19);
		list.add(10);
		System.out.println(RandomSelect(list,2));//无序的
		
		double score = 2*100.00/30;
		System.out.println(score);
		System.out.println(Float.parseFloat(String.format("%.2f", score)));
	}
	
}
