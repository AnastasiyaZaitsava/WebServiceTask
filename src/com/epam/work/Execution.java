package com.epam.work;

import com.epam.data.Book;

public class Execution {
	
	public Execution(){}
	
	public void executeRequest(Request request){
		switch (request.getCommand()){
		case "create":
			createBook(request);
			break;
		case "update":
			updateBook(request);
			break;
		case "read":
			readBook(request);
			break;
		case "delete":
			deleteBook(request);
			break;
		default: 
			System.out.println("No such operation");
			break;
		}
	}
	
	public void createBook(Request request){
		System.out.println("CREATE");
		int id = request.getData().getAllBooks().size() + 1;
		String name = "";
		String author = "";
		String[] bookData = request.getComParam().split("&");
		for(String field: bookData){
			if(field.contains("name")){
				name = field.substring(5);
			}
			else if(field.contains("author")){
				author = field.substring(7);
			}
		}
		request.getData().addBook(new Book(id, name, author));
		System.out.println("CREATED");
	}
	
	public void readBook(Request request){
		System.out.println("READ");
		if(!request.getObjParam().equals("")){
			Book book = request.getData().getBook(Integer.parseInt(request.getObjParam().substring(3)));
			System.out.println(book.getName() + " " + book.getAuthor());
		}
		else{
			for(Book book: request.getData().getAllBooks()){
				System.out.println(book.getName() + " " + book.getAuthor());
			}
		}
		
		
	}
	
	public void updateBook(Request request){
		System.out.println("UPDATE");
	}
	
	public void deleteBook(Request request){
		System.out.println("DELETE");
	}
	
	
}
