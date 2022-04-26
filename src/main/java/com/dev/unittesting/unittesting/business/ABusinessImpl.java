package com.dev.unittesting.unittesting.business;

public class ABusinessImpl {
	
	public int calculateSum(int[] data) {
		int sum = 0;
		for (int value:data) {
			sum += value;
		}
		return sum;
	}
	
	//	public int calculateSumFunctional(int[] dataInfo) {
	//		
	//		return dataInfo.stream()
	//		.reduce((a,b) -> a + b);
	//		.reduce(0, Integer::sum);
	//	}

}
