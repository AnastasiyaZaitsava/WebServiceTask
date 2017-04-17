package com.epam.data;

import java.util.ArrayList;

public class Data {
	private ArrayList<Book> data;
	
	public Data(){
		data = new ArrayList<Book>();
		data.add(new Book(1, "Thinking in Java", "Ekkel"));
		data.add(new Book(2, "C++", "Tannenbaum"));
	}
	
	public void addBook(Book book){
		data.add(book);
	}
}
