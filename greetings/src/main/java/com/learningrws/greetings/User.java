package com.learningrws.greetings;


import java.io.*;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "User")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	
	
	public User(){}

	public User(int id,String name,String description){
		this.id=id;
		this.name=name;
		this.description = description;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	@XmlElement
	public void setId(int id){
		this.id=id;
	}
	
	@XmlElement
	public void setName(String name){
		this.name=name;
	}
	
	@XmlElement
	public void setDescription(String description){
		this.description=description;
	}
}
