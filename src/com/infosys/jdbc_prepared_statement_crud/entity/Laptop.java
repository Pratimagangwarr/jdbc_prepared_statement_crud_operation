package com.infosys.jdbc_prepared_statement_crud.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Laptop implements Serializable {
	// this class works as a container
	// this class use to store and transfer the data
	private int id;
	private String name;
	private String color;
	private double price;

	private LocalDate mfd;

	// to generate no args constructor ALT+S+A (deselect All)

	public Laptop() {
		super();
	}

	// to generate args constructor ALT+S+A (select all)
	public Laptop(int id, String name, String color, double price, LocalDate mfd) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.mfd = mfd;
	}

	// getter and setter methods ALT+S+R
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getMfd() {
		return mfd;
	}

	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}

	// to generate equals(==)() and hashcode method() ALT+Shift+S+H

	@Override
	public int hashCode() {
		return Objects.hash(color, id, mfd, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		return Objects.equals(color, other.color) && id == other.id && Objects.equals(mfd, other.mfd)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	// toString method ALT+Shift+S+S
	// it is java POJO class
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", mfd=" + mfd + "]";
	}

}
