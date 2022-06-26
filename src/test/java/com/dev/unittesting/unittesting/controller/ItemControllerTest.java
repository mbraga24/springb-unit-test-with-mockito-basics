package com.dev.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dev.unittesting.unittesting.business.ItemBusinessService;
import com.dev.unittesting.unittesting.model.Item;

//@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

	/*
	 * STEP 1: Declare MockMvc and Autowired
	 */
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private ItemBusinessService businessService;
	
	@Test
	void shopItem_checkJsonResponseContentWithMatchers() throws Exception {
		/* 
		 * STEP 2: Build the request 
		 * - Needs a builder
		 * - A variable that can store a builder value. (Builds a MockHttpServletRequest)
		 * - Use class containing Static factory methods.
		 * - Invoke a method that represents your CRUD operation.
		 * - What is the Media Type?
		 */
		RequestBuilder request = MockMvcRequestBuilders
				.get("/shop-item")
				.accept(MediaType.APPLICATION_JSON);
		
		/*
		 * STEP 3: Execute the request and retrieve the result. 
		 * - Use mockMvc instance.
		 * - Needs a method to execute (think of a synonym) request. (The return type is ResultActions that allows chaining of further actions)
		 * - Needs to initialize a variable to store the returned content. (Provides access to the result of an executed request)
		 * - Are we expecting anything from this execution? (Implement Matchers)
		 * - Needs to implement an explicit method to return content.
		 */
		MvcResult result = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.content().json("{\"id\": 1,\"name\":\"Sunglasses\",\"price\": 119.99,\"quantity\": 85}")) // tests will still succeed. the json() method understands the json syntax and ignores spaces.
//				.andExpect(MockMvcResultMatchers.content().string("{\"id\": 1,\"name\":\"Sunglasses\",\"price\": 119.99,\"quantity\": 85}")) // this test will fail because when expecting string() the value needs to be exactly like we're expecting from the result. it won't ignore spaces.
				.andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Sunglasses\"}")) // test will still succeed even if the json expected isn't complete. 
				.andReturn();
			
		/*
		 * STEP 4: Verify if the result contains the values we want. (This step varies based on each test case)
		 */
	}
	
	@Test
	public void retrieveItem_checkJsonResponseContentWithMatchers() throws Exception {
		
		when(businessService.retrieveHardcodedItem()).thenReturn(new Item(1, "Iphone 6 Cover - black", 119.95, 85));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-business-sample")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Iphone 6 Cover - black\",\"price\":119.95,\"quantity\":85}"))
				.andReturn();
		
		
		
	}
}
