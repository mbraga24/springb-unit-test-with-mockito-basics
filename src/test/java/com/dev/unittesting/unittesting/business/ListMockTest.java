package com.dev.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
	
	@Test
	public void size_basic() {
		
		List mock = mock(List.class);
		
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	/* 
	 * A method if you want to return different values.
	 * 
	 * returns: 5
	 * returns: 10
	 * 
	 */
	@Test
	public void returnDifferentValues() {
		
		List mock = mock(List.class);
		
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	
	/* 
	 * Defaults - 
	 * 	- numeric (0) 
	 * 	- boolean (false)
	 * 	- Objects (null)
	 * 	- Collections (empty collection)
	 * 
	 */
	@Test
	public void returnWithParameters() {
		
		List mock = mock(List.class);
		
		when(mock.get(0)).thenReturn("hello, buddy!");
		assertEquals("hello, buddy!", mock.get(0));
//		assertEquals("hello, buddy!", mock.get(1)); // test will fail
		assertEquals(null, mock.get(1));
	}
	
	
	/*
	 * Argument Matcher
	 * 
	 * anyInt() is called an argument matcher. There are several other argument matchers available in
	 * mockito.
	 * 
	 * When a method is called on a Mock which matches the argument matcher, it will return the value
	 * specified in .thenReturn() 
	 * 
	 */
	@Test
	public void returnWithGenericParameters() {
		List mock = mock(List.class);
		
		when(mock.get(anyInt())).thenReturn("hello, you!");
		
		assertEquals("hello, you!", mock.get(0));
		assertEquals("hello, you!", mock.get(1));	
	}

	/*
	 * Verification
	 *
	 * In the code tested, get method is called with a parameter 0. That's what it's going to 
	 * be verified.
	 * 
	 */
	@Test
	public void verificationBasics() {
		
//		SUT - SYSTEM UNDER TEST
		List<String> mock = mock(List.class);
		
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
//		Verification
		
//		verify if the (mock) get method is call with specific parameter
		verify(mock).get(0);
//		verify if the (mock) get method is called with anyInt() - argument matcher
//		verify(mock).get(anyInt()); // will fail - error: wanted 1 but it was 2 times
//		verify the number of times a specific (mock) get method is called
		verify(mock, times(2)).get(anyInt());
//		verify if the (mock) get method is called at least n number of times
		verify(mock, atLeast(1)).get(anyInt());
		
//		other conditions
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
		verify(mock, atLeastOnce()).get(anyInt());
	}
	
	/*
	 * Argument Capture
	 * 
	 * Capturing argument that is passed to the method call.
	 */
	@Test
	public void argumentCapturing() {
		
//		SUT - SYSTEM UNDER TEST
		List<String> mock = mock(List.class);
		
		mock.add("This is an example of a String passed to the method as an argument");
		
//		Verification
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("This is an example of a String passed to the method as an argument", captor.getValue());
		
		
		// ====> EXERCISE: CREATE A TEST TO CHECK IF THE METHOD CALL HAS AN INTERGER, A LIST AND ARRAY
		
	}
	
	/*
	 * Argument Capture
	 * 
	 * Capturing multiple arguments on multiple method calls.
	 */
	@Test
	public void multipleArgumentCapturing() {
		
//		SUT - SYSTEM UNDER TEST
		List<String> mock = mock(List.class);
		
		mock.add("I will write smaller strings");
		mock.add("This one is smaller");
		mock.add("...");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(3)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		
		assertEquals("I will write smaller strings", allValues.get(0));
		assertEquals("This one is smaller", allValues.get(1));
		assertEquals("...", allValues.get(2));
		
	}
	
	
}
