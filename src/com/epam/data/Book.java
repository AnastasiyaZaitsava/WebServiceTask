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
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setAuthor(String author){
		this.author = author;
	}
	
	public String toString(){
		String book = "ID: "+ this.id + ";  Name: " + this.name + "; Author: " + this.author + ";\n";
		return book;
	}
}
