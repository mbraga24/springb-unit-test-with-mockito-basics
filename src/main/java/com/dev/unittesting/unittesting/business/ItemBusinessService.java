package com.dev.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.unittesting.unittesting.data.ItemRepository;
import com.dev.unittesting.unittesting.helper.BusinessHelper;
import com.dev.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item retrieveHardcodedItem() {
		return new Item(1, "Iphone 6 Cover - black", 119.95, 85);
	}

	public List<Item> retrieveAllItems20Off() {
		List<Item> items = itemRepository.findAll();
		
		double newPrice = 0.0;
		for (Item item:items) {
			newPrice = BusinessHelper.roundTwoDecimals(20.0, item.getPrice());
			item.setPrice(newPrice);
		}
		return items;
	}
	
	public List<Item> retrieveAllItems() {
		return itemRepository.findAll();
	}
	
}
