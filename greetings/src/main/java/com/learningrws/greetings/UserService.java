 package com.learningrws.greetings;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.*;

@Path("/UserService")
public class UserService {
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Hashtable<Integer,User> getAllUsers(){
		userDAO uDAO = new userDAO();
		//List<User> usersList = uDAO.getUsers();
		Hashtable<Integer,User> usersTable=uDAO.getUsersTable();
		return usersTable;
	}
	
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserBy(@PathParam("userId") int userId){
		userDAO uDAO = new userDAO();
		return uDAO.getUserBy(userId);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User AddNewUser(User aUser){
		userDAO uDAO = new userDAO();
		return uDAO.addNewUser(aUser);
	}
	
	@DELETE
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User deleteUser(@PathParam("userId") int userId){
		userDAO uDAO = new userDAO();
		return uDAO.deleteUser(userId);
	}
	
	
	
}
