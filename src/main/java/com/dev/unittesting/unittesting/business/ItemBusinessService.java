package com.dev.unittesting.unittesting.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dev.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {
	
	public Item retrieveOneItem() {
		return new Item(2, "Iphone 6 Cover - black", 119.95, 85);
	}
	
	public List<Item> retrieveMultipleItems() {
		
		List<Item> items = new ArrayList<Item>();
		
		items.add(new Item(3, "Flip-flops - Havaianas", 23.99, 4));
		items.add(new Item(4, "Yankees Hat", 49.99, 13));
		
		return items;
	}
	
}
