package com.dev.unittesting.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.unittesting.unittesting.model.Item;

@RestController
public class ItemController {
	
	@GetMapping("/shop-item")
	public Item thisItem() {
		return new Item(1, "Sunglasses", 119.99, 85);
	}
	
}
