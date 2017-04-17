package com.epam.work;

public class Request {
	String object;
	String objParam;
	String command;
	String comParam;
	
	
	public Request(String req){
		String[] formedReq = parseRequest(req);
		object = formedReq[0];
		objParam = formedReq[1];
		command = formedReq[2];
		comParam = formedReq[3];
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
	
	public static String[] parseRequest(String req){
		String[] formedReq = new String[4];
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
		if (parsed1.length>2){
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
		return formedReq;
	}
}
