package com.jdeisinger.springCrudDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/customer")
	public List<Customer> customer(@RequestParam(value="name", defaultValue="*") String name) {
		List<Customer> c; 
		if(name.equals("*")) {
			c = jdbcTemplate.query("SELECT * from customers", new Object[] {},
					(rs, rowNum) -> { 
						return new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")); 
					});
		}
		else {
			c = jdbcTemplate.query("SELECT * from customers WHERE first_name = ?", new Object[] { name }, 
				(rs, rowNum) -> { return new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")); });
		}
		return c;
	}
	@RequestMapping("/customer/add")
	public Customer addCustomer(@RequestParam(value="name", defaultValue="*") String name) {
		String[] splitName = name.split(" ");
		Customer c = new Customer(2, splitName[0], splitName[1]);
		jdbcTemplate.update("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitName);
		return c;
	}
}
