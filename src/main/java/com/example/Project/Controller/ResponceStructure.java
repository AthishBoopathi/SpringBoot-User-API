package com.example.Project.Controller;

public class ResponceStructure <U>{
	
	private int statuscode;
	private String message;
	private U data;
	
	
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public U getData() {
		return data;
	}
	public void setData(U data) {
		this.data = data;
	}
	
	
	
	

}
