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
	
	@GetMapping("/shop-item")
	public Item thisItem() {
		return new Item(1, "Sunglasses", 119.95, 85);
	}
	
	@GetMapping("/item-business-sample")
	public Item retrieveItem() {
		return businessService.retrieveHardcodedItem();
	}
	
	@GetMapping("/list-all")
	public List<Item> retrieveAll() {
		return businessService.retrieveAllItems();
	}
	
	@GetMapping("/list-all-off")
	public List<Item> retrieveAll20Off() {
		return businessService.retrieveAllItems20Off();
	}
	
}
