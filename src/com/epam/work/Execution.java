package com.epam.work;

import com.epam.data.Book;

public class Execution {
	
	public Execution(){}
	
	public Responce executeRequest(Request request){
		Responce responce = new Responce();
		switch (request.getCommand()){
		case "create":
			responce = createBook(request);
			break;
		case "update":
			updateBook(request);
			break;
		case "read":
			responce = readBook(request);
			break;
		case "delete":
			deleteBook(request);
			break;
		default: 
			responce = new Responce(400, "Wrong Request", "");
			break;
		}
		return responce;
	}
	
	public Responce createBook(Request request){
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
		Responce responce = new Responce(200, "OK", "Book has been created");
		return responce;
	}
	
	public Responce readBook(Request request){
		System.out.println("READ");
		Responce responce;
		if(!request.getObjParam().equals("")){
			Book book = request.getData().getBook(Integer.parseInt(request.getObjParam().substring(3)));
			if(book == null){
				responce = new Responce(404, "Not found", "Book with that id not found");
			}
			else{
				responce = new Responce(200, "OK", book.toString());
			}
		}
		else{
			String books = "";
			for(Book book: request.getData().getAllBooks()){
				books += book.toString();;
			}
			responce = new Responce(200, "OK", books);
		}
		return responce;		
	}
	
	public void updateBook(Request request){
		System.out.println("UPDATE");
	}
	
	public void deleteBook(Request request){
		System.out.println("DELETE");
	}
	
	
}
