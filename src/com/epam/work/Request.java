package com.epam.work;

import com.epam.data.Data;

public class Request {
	private String object;
	private String objParam;
	private String command;
	private String comParam;
	private String format;
	public static Data data = new Data();
	
	
	public Request(String req){
		String[] formedReq = parseRequest(req);
		object = formedReq[0];
		objParam = formedReq[1];
		command = formedReq[2];
		comParam = formedReq[3];
		format = formedReq[4];
	}
	
	public String getObject(){
		return this.object;
	}
	
	public String getObjParam(){
		return this.objParam;
	}
	
	public String getCommand(){
		return this.command;
	}
	
	public String getComParam(){
		return this.comParam;
	}
	
	public String getFormat(){
		return this.format;
	}
	
	public Data getData(){
		return this.data;
	}
	
	public static String[] parseRequest(String req){
		String[] formedReq = new String[5];
		String[] parsed1 = req.split("/");		
		if(parsed1[1].contains("?")){
			String[] obj = parsed1[1].split("\\?");
			formedReq[0] = obj[0];
			formedReq[1] = obj[1];
		}
		else{
			formedReq[0] = parsed1[1];
			formedReq[1] = "";
		}
		if(parsed1.length>2){
			if(parsed1[2].contains("?")){
				String[] command = parsed1[2].split("\\?");
				formedReq[2] = command[0];
				formedReq[3] = command[1];
			}
			else{
				formedReq[2] = parsed1[2];
				formedReq[3] = "";
			}
		}
		else{
			formedReq[2] = "";
			formedReq[3] = "";
		}
	
		if(parsed1.length>3){
			if(parsed1[3].equalsIgnoreCase("xml")){
				formedReq[4] = "xml";
			}
			else if (parsed1[3].equalsIgnoreCase("json")){
				formedReq[4] = "json";
			}
			else{
				formedReq[4] = "default";
			}
		}
		else{
			formedReq[4] = "default";
		}
		return formedReq;
	}
	
	public Responce execute(){
		Execution ex = new Execution();
		Responce responce = ex.executeRequest(this);;
		return responce;
	}
}
