package com.dev.unittesting.unittesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@RunWith(SpringRunner.class)
@WebMvcTest(Greetings.class) // List the MockMvc framework for use
public class GreetingsTest {
	
	/*
	 * STEP 1: Autowired the MockMvc
	 */
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void greetings_checkResponseContent() throws Exception {
		/* 
		 * STEP 2: Build the request
		 *  
		 * Call: GET	"/greetings" 
		 * Media Type: application/json
		 *
		 * RequestBuilder: Builds a MockHttpServletRequest.
		 * MockMvcRequestBuilders: Static factory methods for RequestBuilder RequestBuilders.
		 */		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/greetings")
				.accept(MediaType.APPLICATION_JSON);
		/*
		 * STEP 3: Execute the request and retrieve the result. 
		 *  
		 * MvcResult: Provides access to the result of an executed request.
		 * .perform(): Perform a request and return a type (ResultActions) that allows chaining further
		 * 				actions, such as asserting expectations, on the result.
		 * .andReturn(): Return the result of the executed request for direct access to the results.
		 */
		MvcResult result = mockMvc.perform(request).andReturn();
		
		/*
		 * STEP 4: Verify if the result contains the values we want. 
		 * 
		 * .getResponse: Return the resulting response.
		 * .getContentAsString(): Get the content of the response body as a String.
		 */
		assertEquals("Greetings!!", result.getResponse().getContentAsString()); // Verify "Greetings!"
	}
	
}
