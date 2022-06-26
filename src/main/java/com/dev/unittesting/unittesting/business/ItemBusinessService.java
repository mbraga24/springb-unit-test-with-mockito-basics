package com.dev.unittesting.unittesting.business;

import org.springframework.stereotype.Component;

import com.dev.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {
	
	public Item retrieveHardcodedItem() {
		return new Item(1, "Iphone 6 Cover - black", 119.95, 85);
	}

}
