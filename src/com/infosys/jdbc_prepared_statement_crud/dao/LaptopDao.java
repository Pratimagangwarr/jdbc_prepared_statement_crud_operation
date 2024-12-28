
package com.infosys.jdbc_prepared_statement_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.infosys.jdbc_prepared_statement_crud.connection.LaptopConnection;
import com.infosys.jdbc_prepared_statement_crud.entity.Laptop;

public class LaptopDao {

	// private static final String DELETELAPTOPQUERY = null;

	Connection connection = LaptopConnection.getLaptopConnection();

	private final String INSERTLAPTOPQUERY = "insert into laptop(id,name,color,price,mfd) values(?,?,?,?,?)";

	private final String DELETELAPTOPQUERY = "delete from laptop where id=?";

	private final String DISPLAYLAPTOPQUERY = "SELECT * FROM LAPTOP";

	public Laptop saveLaptopDao(Laptop laptop) {

		try {
			PreparedStatement ps = connection.prepareStatement(INSERTLAPTOPQUERY);
			ps.setInt(1, laptop.getId());
			ps.setString(2, laptop.getName());
			ps.setString(3, laptop.getColor());
			ps.setDouble(4, laptop.getPrice());
			ps.setObject(5, laptop.getMfd());

			int a = ps.executeUpdate();

			return a != 0 ? laptop : null;
		}

		catch (SQLException e) {
			e.printStackTrace();

			return null;

		}
	}

	public int deleteLaptopByIdDao(int LAptopId) {
		try {
			
			PreparedStatement ps = connection.prepareStatement(DELETELAPTOPQUERY);
			ps.setInt(1, LAptopId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	public List<Laptop> getAllLaptopDao() {

		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAYLAPTOPQUERY);
			ResultSet set = ps.executeQuery();
			List<Laptop> laptops  = new ArrayList<Laptop>();

			while (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String color = set.getString("color");
				Double price = set.getDouble("price");
				LocalDate mfd = set.getDate("mfd").toLocalDate(); //method chaining

				Laptop laptop = new Laptop(id, name, color, price, mfd);
				
				laptops.add(laptop);

			
			}
			return laptops;
			

		}catch (SQLException e) {

			e.printStackTrace();

			return null;

		}

	}

// Batch processing with prepared statement
	
	
public List<Laptop> savemultipleLaptopsDao(List<Laptop> laptops) {
	PreparedStatement ps = null;
	
	
		  try {
			  ps = connection.prepareStatement(INSERTLAPTOPQUERY);
			  for (Laptop laptop : laptops) {
			
				ps.setInt(1, laptop.getId());
				ps.setString(2, laptop.getName());
				ps.setString(3, laptop.getColor());
				ps.setDouble(4, laptop.getPrice());
				ps.setObject(5, laptop.getMfd());

				ps.addBatch();
			  
		  } 
		 
			  int a[] = ps.executeBatch();
			  System.out.println(a.length + "no. of row affected");
		  
	          return laptops;
		  
	  } catch (SQLException e) {

			e.printStackTrace();
			return null;
       }
}
	
}























