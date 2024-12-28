
package com.infosys.jdbc_prepared_statement_crud.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.infosys.jdbc_prepared_statement_crud.dao.LaptopDao;
import com.infosys.jdbc_prepared_statement_crud.entity.Laptop;
import com.infosys.jdbc_prepared_statement_crud.service.LaptopService;

public class LaptopController {
	// work as a front end

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LaptopDao dao = new LaptopDao();
		LaptopService service = new LaptopService();

		while (true) {

			System.out.println("1.INSERT\n2.DELETE\n3.DisplayByFilterByPrice\n4.DISPLAY\n5.InsertMultipleLaptops");
			System.out.println("please enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {

				System.out.println("enter laptop id");
				int id = scanner.nextInt();
				System.out.println("enter laptop name");
				String name = scanner.next();
				System.out.println("enter laptop color");
				String color = scanner.next();
				System.out.println("enter laptop price");
				double price = scanner.nextDouble();

				// pass mfd (yy-mm-dd) ("19-09-11")
				System.out.println("enter laptop mfd date");
				String mfd = scanner.next();

//			 LocalDate date = LocalDate.parse(mfd);

				// Laptop laptop = new Laptop(id,name,color,price,LocalDate.parse(mfd));

				Laptop laptop = service.saveLaptopService(new Laptop(id, name, color, price, LocalDate.parse(mfd)));

				String msg = laptop != null ? "success" : "data not stored";

				System.out.println(msg);

			}
				break;
			case 2: {

				System.out.println("enter laptop id");
				int id = scanner.nextInt();
				int a = dao.deleteLaptopByIdDao(id);

				String msg = a != 0 ? "DELETED" : "GIVEN ID NOT PRESENT OR CHECK YOUR CODE";
				System.out.println(msg);

			}
				break;
			case 3: {
				System.out.println("enter laptop price");
				double price = scanner.nextDouble();

				List<Laptop> laptops = service.filterLaptopByPriceService(price);
				if (laptops.isEmpty()) {
					System.out.println("given price is not available");
				} else {

					for (Laptop laptop : laptops) {

						System.out.println(laptop);
					}
				}
			}
				break;

			case 4: {
				List<Laptop> laptops = dao.getAllLaptopDao();

				for (Laptop laptop : laptops) {
					System.out.println(laptop);

				}

			}
				break;
			case 5: {
				System.out.println("how many laptops you want to add....");
				int size = scanner.nextInt();
				List<Laptop> laptops = new ArrayList <Laptop>();
				for (int i = 0; i < size; i++) {
					System.out.println("enter " + i + "laptop");

					System.out.println("enter laptop id");
					int id = scanner.nextInt();
					System.out.println("enter laptop name");
					String name = scanner.next();
					System.out.println("enter laptop color");
					String color = scanner.next();
					System.out.println("enter laptop price");
					double price = scanner.nextDouble();

					// pass mfd (yy-mm-dd) ("19-09-11")
					System.out.println("enter laptop mfd date");
					String mfd = scanner.next();

			
					// LocalDate date = LocalDate.parse(mfd);

					 Laptop laptop = new Laptop(id,name,color,price,LocalDate.parse(mfd));
					 laptops.add(laptop);
				}
				List<Laptop> laptops2 = dao.savemultipleLaptopsDao(laptops);


				}
				break;

			}
			}
		}
	}

