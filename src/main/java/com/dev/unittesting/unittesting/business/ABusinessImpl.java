package com.dev.unittesting.unittesting.business;

import com.dev.unittesting.unittesting.data.ADataService;

public class ABusinessImpl {
	
	ADataService aDataService;

	public void setaDataService(ADataService aDataService) {
		this.aDataService = aDataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for (int value:data) {
			sum += value;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		
		int sum = 0;
		int[] data = aDataService.retrieveAllData();
		
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
