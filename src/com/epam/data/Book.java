package com.epam.data;

public class Book {
	private int id;
	private String name;
	private String author;
		
	public Book(){}
	
	public Book(int id, String name, String auth){
		this.id = id;
		this.name = name;
		this.author = auth;
	}
	
	public int getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	public String getAuthor(){
		return author;
	}

}
