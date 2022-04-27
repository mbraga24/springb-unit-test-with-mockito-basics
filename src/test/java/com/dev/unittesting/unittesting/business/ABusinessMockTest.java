package com.dev.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dev.unittesting.unittesting.data.ADataService;

/*
 * A Stub implementation of the service will avoid having any code connecting to the database.
 * Unit testing should not be depending on anything outside of it.
 */

@ExtendWith(MockitoExtension.class)
public class ABusinessMockTest {

	@InjectMocks
	ABusinessImpl aBusinessImpl = new ABusinessImpl();		
	
	@Mock
	ADataService aDataServiceMock;
	
	@Test
	public void calculateSumUsingADataService_basic() {
		when(aDataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6,  aBusinessImpl.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingADataService_emptyArray() {
		when(aDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0,  aBusinessImpl.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingADataService_oneValue() {
		when(aDataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		assertEquals(5,  aBusinessImpl.calculateSumUsingDataService());
	}
}