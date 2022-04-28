package com.dev.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListMockTest {
	
	@Test
	public void size_basic() {
		
		List mock = mock(List.class);
		
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		
		List mock = mock(List.class);
		
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		
		List mock = mock(List.class);
		
		when(mock.get(0)).thenReturn("hello, buddy!");
		assertEquals("hello, buddy!", mock.get(0));
//		assertEquals("hello, buddy!", mock.get(1)); // test will fail
		assertEquals(null, mock.get(1));
	}

}
