package com.epam.work;

import java.util.ArrayList;

import com.epam.data.Book;
import com.epam.data.Data;

public class Execution {
	private ArrayList<Book> data = Data.getData();
	
	public Execution(){}
	
	public Responce executeRequest(Request request){
		Responce responce = new Responce();
		switch (request.getCommand()){
		case "create":
			responce = createBook(request);
			break;
		case "update":
			responce = updateBook(request);
			break;
		case "read":
			responce = readBook(request);
			break;
		case "delete":
			responce = deleteBook(request);
			break;
		default: 
			responce = new Responce(400, "Wrong Request", "");
			break;
		}
		return responce;
	}
	
	public Responce createBook(Request request){
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
		int id = Data.getNewID();
		Data.addBook(new Book(id, name, author));
		Responce responce = new Responce(201, "Created", "Book has been created");
		return responce;
	}
	
	public Responce readBook(Request request){
		System.out.println("READ");
		Responce responce;
		if(!request.getObjParam().equals("")){
			Book book = Data.getBook(request.getBookIDFromReq());
			if(book == null){
				responce = new Responce(404, "Not found", "Book with that id not found");
			}
			else{
				responce = new Responce(200, "OK", book.toString());
			}
		}
		else{
			String books = "";
			for(Book book: data){
				books += book.toString();
			}
			responce = new Responce(200, "OK", books);
		}
		return responce;		
	}
	
	public Responce updateBook(Request request){
		System.out.println("UPDATE");
		Book book = Data.getBook(request.getBookIDFromReq());
		String[] bookData = request.getComParam().split("&");
		if (book != null){
			for(String field: bookData){
				if(field.contains("name")){
					String newName = field.substring(5);
					book.setName(newName);
					
				}
				else if(field.contains("author")){
					String newAuthor = field.substring(7);
					book.setAuthor(newAuthor);
					
				}
				else if(field.contains("id")){
					int newID = Integer.parseInt(field.substring(3));
					book.setID(newID);
				}
			}
			Responce responce = new Responce(200, "OK", "Book has been updated successfully");
			return responce;
		}
		else{
			Responce responce = new Responce(404, "Not found", "Book with that id not found");
			return responce;
		}
		
	}
	
	public Responce deleteBook(Request request){
		System.out.println("DELETE");
		Responce responce;
		if(!request.getObjParam().equals("")){
			Book book = Data.getBook(request.getBookIDFromReq());
			if(book == null){
				responce = new Responce(404, "Not found", "Book has been already deleted or never existed");
			}
			else{
				if(Data.getAllBooks().remove(book)){
					responce = new Responce(200, "OK", "Book has been deleted successfully!");
				}
				else{
					responce = new Responce(500, "Internal Server Error", "Something goes wrong :(");
				}
			}
		}
		else{
			if(data.removeAll(data)){
				responce = new Responce(200, "OK", "All books has been deleted");
			}
			else{
				responce = new Responce(500, "Internal Server Error", "Something goes wrong :(");
			}
		}
		return responce;	
	}
	
	
}
