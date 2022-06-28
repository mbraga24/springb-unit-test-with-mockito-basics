package com.dev.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.unittesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
