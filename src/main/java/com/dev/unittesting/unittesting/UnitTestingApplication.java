package com.dev.unittesting.unittesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class UnitTestingApplication implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String sql = "insert into item(id, name, price, quantity) values(?, ?, ?, ?)";
		int item1 = jdbcTemplate.update(sql, 10001, "Iphone 11 cover", 29.99, 11);
		int item2 = jdbcTemplate.update(sql, 10002, "Yankees hat", 59.99, 4);
		int item3 = jdbcTemplate.update(sql, 10003, "Sleeping Shorts", 39.99, 6);
		int item4 = jdbcTemplate.update(sql, 10004, "Blue Polo Shirts", 19.99, 2);
		
		
		if (doesItExist(item1) && doesItExist(item2) && doesItExist(item3) && doesItExist(item4)) {
			System.out.println("============> NEW ROLLS HAVE BEEN INSERTED.");
		}
	}
	
	private boolean doesItExist(int item) {
		if (item > 0) return true;		
		System.out.println("============> One or more items already exist.");
		return false;
	}
	
}
