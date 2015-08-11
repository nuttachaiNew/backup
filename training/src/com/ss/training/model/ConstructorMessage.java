package com.ss.training.model;

public class ConstructorMessage {
	private String message;
	
	
	public ConstructorMessage(String message){
		this.message=message;
	}
	
	public String getMessage(){
		return message;
		
	}
	public void setMessage(String message){
		this.message=message;
	}
}
