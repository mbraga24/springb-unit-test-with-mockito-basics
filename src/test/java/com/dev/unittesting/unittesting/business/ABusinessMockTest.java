package com.dev.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.dev.unittesting.unittesting.data.ADataService;

/*
 * A Stub implementation of the service will avoid having any code connecting to the database.
 * Unit testing should not be depending on anything outside of it.
 */

public class ABusinessMockTest {

	@Test
	public void calculateSumUsingADataService_basic() {
		ABusinessImpl aBusinessImpl = new ABusinessImpl();		
		
//		set local variable to the mock of the service
		ADataService aDataServiceMock = mock(ADataService.class);
		
//		apply when(some action performs).thenReturn(should return a value)
		when(aDataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		
//		set the service to the mock of the service 
		aBusinessImpl.setaDataService(aDataServiceMock);
		
		int actualResult = aBusinessImpl.calculateSumUsingDataService(); // new int[] {1,2,3}
		int expectedResult = 6;
		
		assertEquals(expectedResult, actualResult);		
	}
	
	@Test
	public void calculateSumUsingADataService_emptyArray() {
		ABusinessImpl aBusinessImpl = new ABusinessImpl();
		
		ADataService aDataServiceMock = mock(ADataService.class);
		
		when(aDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		
		aBusinessImpl.setaDataService(aDataServiceMock);
		
		int actualResult = aBusinessImpl.calculateSumUsingDataService(); // new int[] {}
		int expectedResult = 0;
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingADataService_oneValue() {
		ABusinessImpl aBusinessImpl = new ABusinessImpl();
		
		ADataService aDataServiceMock = mock(ADataService.class);
		
		when(aDataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		
		aBusinessImpl.setaDataService(aDataServiceMock);
		
		int actualResult = aBusinessImpl.calculateSumUsingDataService(); // new int[] {5}
		int expectedResult = 5;
		
		assertEquals(expectedResult, actualResult);
	}
}
