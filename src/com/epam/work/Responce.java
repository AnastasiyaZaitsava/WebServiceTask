package com.epam.work;

public class Responce {
	private int code;
	private String message;
	private String info;
	
	public Responce(){
		code = 0;
		message = "";
	}
	
	public Responce(int code, String message, String info){
		this.code = code;
		this.message = message;
		this.info = info;
	}
	
	public int getCode(){
		return code;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getInfo(){
		return info;
	}
}
