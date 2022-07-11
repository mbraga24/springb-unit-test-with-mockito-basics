package com.dev.unittesting.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.unittesting.unittesting.business.ItemBusinessService;
import com.dev.unittesting.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService businessService;
	
	@GetMapping("/hardcoded-item")
	public Item hardcoded() {
		return new Item(1, "Sunglasses", 119.95, 85);
	}
	
	@GetMapping("/one-item")
	public Item retrieveOneItem() {
		return businessService.retrieveOneItem();
	}
	
	@GetMapping("/multiple-items")
	public List<Item> retrieveMultipleItems() {
		return businessService.retrieveMultipleItems();
	}
	
}
