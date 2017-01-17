package com.jdeisinger.springCrudDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CustomerController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/customer")
	public String customer(@RequestParam(value="name", defaultValue="*") String name, Model model) {
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
		model.addAttribute("c", c);
		return "index";
	}
	@RequestMapping(value = "/customer", method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("name") String name) {
		String[] splitName = name.split(" ");
		Customer c = new Customer(2, splitName[0], splitName[1]);
		jdbcTemplate.update("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitName);
		return "add";
	}
	@RequestMapping(value = "/customer/delete", method=RequestMethod.GET)
	public String delCustomer(@RequestParam("id") String id, Model model) {
		model.addAttribute("id", id);
		jdbcTemplate.update("DELETE FROM customers WHERE id = ?", id);
		return "del";
	}
	
	public void test() {
		System.out.println("LOOKS GOOD");
	}
}
