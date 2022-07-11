package com.dev.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;

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
public class ItemControllerTest {

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
				.get("/hardcoded-item")
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
				// .andExpect(MockMvcResultMatchers.content().json("{\"id\": 1,\"name\":\"Sunglasses\",\"price\": 119.99,\"quantity\": 85}")) // tests will still succeed. the json() method understands the json syntax and ignores spaces.
				// .andExpect(MockMvcResultMatchers.content().string("{\"id\": 1,\"name\":\"Sunglasses\",\"price\": 119.99,\"quantity\": 85}")) // this test will fail because when expecting string() the value needs to be exactly like we're expecting from the result. it won't ignore spaces.
				.andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Sunglasses\"}")) // test will still succeed even if the json expected isn't complete. 
				.andReturn();
			
		/*
		 * STEP 4: Verify if the result contains the values we want. (This step varies based on each test case)
		 */
	}
	
	@Test
	void testRetrieveItem_checkJsonResponseContentWithMatchers() throws Exception {
		
		when(businessService.retrieveOneItem()).thenReturn(
				new Item(1, "Item_1", 10, 10));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/one-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{id:1, name: Item_1, price: 10, quantity: 10}"))
				.andReturn();
	}
	
	@Test
	void testRetrieveMultipleItems_checkJsonResponseContentWithMatchers() throws Exception {
		
		when(businessService.retrieveMultipleItems()).thenReturn(
				Arrays.asList(new Item(1, "Item_1", 10, 10),
							  new Item(2, "Item_2", 20, 20))
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/multiple-items")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("[{id: 1, name: Item_1, price: 10, quantity: 10}, {id: 2, name: Item_2, price: 20, quantity: 20}]"))
				.andReturn();
	}
	
}
