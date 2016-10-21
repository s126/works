package com.s126.demo.bean;

import java.util.ArrayList;
import java.util.List;


public class Student {
	private String name;
	private int age;
	private Computer comp;
	private List<Book> books = new ArrayList<Book>();

	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Computer getComp() {
		return comp;
	}


	public void setComp(Computer comp) {
		this.comp = comp;
	}


	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
