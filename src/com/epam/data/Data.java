package com.epam.data;

import java.util.ArrayList;


public class Data {
	private static ArrayList<Book> data;
	
	private Data(){	}
	
	public static ArrayList<Book> getData(){
		if (data == null){
			data = new ArrayList<Book>();
			data.add(new Book(1, "Thinking in Java", "Ekkel"));
			data.add(new Book(2, "C++", "Tannenbaum"));
		}
		return data;
	}
	public static void addBook(Book book){
		data.add(book);
	}
	
	public static ArrayList<Book> getAllBooks(){
		return data;
	}
	
	public static int getNewID(){
		int maxID = data.get(0).getID();
		for(Book book: data){
			if (book.getID()>maxID){
				maxID = book.getID();
			}
		}
		return maxID+1;
	}
	
	public static Book getBook(int id){
		for (Book book: data){
			if (id == book.getID()){
				return book;
			}
		}
		return null;
	}
}
