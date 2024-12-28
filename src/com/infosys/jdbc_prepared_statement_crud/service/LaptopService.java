package com.infosys.jdbc_prepared_statement_crud.service;

import java.util.List;
import java.util.stream.Collectors;

import com.infosys.jdbc_prepared_statement_crud.dao.LaptopDao;
import com.infosys.jdbc_prepared_statement_crud.entity.Laptop;

public class LaptopService {
	LaptopDao dao = new LaptopDao();

	public Laptop saveLaptopService(Laptop laptop) {

		String lName = laptop.getName();
		double price = laptop.getPrice();

		if ((lName.length() <= 5)&&(price >= 30000&&price <= 40000)) {
			Laptop laptop1 = dao.saveLaptopDao(laptop);
			return laptop1;
		} else {
			System.out.println("laptop name length should be 5 or less & price should be between 30000 to 40000");
			return null;
		}

	}
	
	
	public List<Laptop> filterLaptopByPriceService(double price){
		
		List<Laptop> laptops=dao.getAllLaptopDao();
		
		List<Laptop> filters = laptops
				.stream()
				.filter(a->a.getPrice()<=price)
				.collect(Collectors.toList());
		return filters;
	}
	
	
}
