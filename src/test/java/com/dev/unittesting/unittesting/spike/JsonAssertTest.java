package com.dev.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/*
 * This test class analyzes JSONAssert class in depth.
 */
class JsonAssertTest {

	/*
	 * Response that we would get from a service.
	 */
	String actualResponse = "{\"id\":1,\"name\":\"Sunglasses\",\"price\":119.99,\"quantity\":85}";
	
	/*
	 * CASE 1:
	 * assertEquals(expectedStr, actualStr, strict);
	 * 
	 * When strict is set to true and both expected and actual responses match with 
	 * exception of spaces the test will succeed.
	 */
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\": 1,\"name\": \"Sunglasses\",\"price\": 119.99,\"quantity\":85}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	/* 
	 * CASE 2:
	 * assertEquals(expectedStr, actualStr, strict);
	 * 
	 * When strict is set to true and both expected and actual responses aren't matching,
	 * with one of them with missing values, the test will fail. The exact structure needs 
	 * to match.
	 */
	@Test
	public void jsonAssert_StrictTrue_MissingProperties() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Sunglasses\"}";
		
		JSONAssert.assertEquals(expectedResponse, actualResponse, true); 
		
	}
	
	/*
	 * CASE 3:
	 * assertEquals(expectedStr, actualStr, strict);
	 * 
	 * When strict is set to false and both expected and actual responses match with 
	 * exception of spaces, the test will return true.
	 */
	@Test
	public void jsonAssert_StrictFalse_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\": 1,\"name\": \"Sunglasses\",\"price\": 119.99,\"quantity\":85}";
		
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	/*
	 * CASE 3:
	 * assertEquals(expectedStr, actualStr, strict);
	 * 
	 * When strict is set to false and one of the responses is a json response without 
	 * space characters, the test will return true.
	 */
	@Test
	public void jsonAssert_StrictFalse_WithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id: 1,name: Sunglasses, price: 119.99, quantity:85}";
		
		JSONAssert.assertEquals(expectedResponse, actualResponseWithoutEscapeCharacters, false);
	}

}
