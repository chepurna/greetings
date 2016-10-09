package com.learningrws.greetings;

import java.util.*;
import java.io.*;

public class userDAO {
	
	
	//While creating instance of DAO want to ensure the file exists with atleast one record
	public userDAO(){
		try{
			Hashtable<Integer,User> UsersTable= null;
			List<User> usersList = null;
			File f = new File("E:\\doit\\Users.dat");
			if(!f.exists()){
				User aUser = new User(1,"Jagadish","Teacher");
				usersList = new ArrayList<User>();
				UsersTable = new Hashtable<Integer,User>();
				usersList.add(aUser);
				UsersTable.put(aUser.getId(), aUser);
				//SaveUsersList(usersList);
				SaveUsersTable(UsersTable);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*public List<User> getUsers(){
		List<User> usersList = null;
		try{
			File f = new File("E:\\doit\\Users.dat");
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				usersList = (List<User>) ois.readObject();
				ois.close();
				fis.close();
				
			}catch(Exception e){
			e.printStackTrace();
		}
		return usersList;
	}*/
	
	public Hashtable<Integer,User> getUsersTable(){
		Hashtable<Integer,User> usersTable = null;
	try{
		File f = new File("E:\\doit\\Users.dat");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			usersTable = (Hashtable<Integer,User>) ois.readObject();
			ois.close();
			fis.close();
			
		}catch(Exception e){
		e.printStackTrace();
	}
	return usersTable;
}

	
	
	/*public void SaveUsersList(List<User> usersList){
		try{
		File f = new File("E:\\doit\\users.dat");
		
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos  = new ObjectOutputStream(fos);
		oos.writeObject(usersList);
		oos.close();
		fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/

	public void SaveUsersTable(Hashtable<Integer,User> usersTable){
		try{
		File f = new File("E:\\doit\\users.dat");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos  = new ObjectOutputStream(fos);
		oos.writeObject(usersTable);
		oos.close();
		fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*public User addNewUser(User aUser){
		try{
			//aUser = new User(id,name,description);
			List<User> allUsers = getUsers();
			//usersList = getUsers();
			//usersList.add(aUser);
			allUsers.add(aUser);
			//SaveUsersList(usersList);
			//SaveUsersList(allUsers);
		}catch(Exception e){
			e.printStackTrace();
		}
		return aUser;
	}*/
	
	public User addNewUser(User aUser){
		try{
			//aUser = new User(id,name,description);
			Hashtable<Integer,User> usersTable = getUsersTable();
			if(usersTable.get(aUser.getId()) == null){	
				usersTable.put(aUser.getId(), aUser);
				SaveUsersTable(usersTable);
			}else{
				System.out.println("user already exists, user defined exception will be raised soon......");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return aUser;
	}
	
	public User deleteUser(int userId){
		User dUser = null;
		try{
			//aUser = new User(id,name,description);
			Hashtable<Integer,User> usersTable = getUsersTable();
			dUser = usersTable.get(userId);
			if(dUser != null){	
				//usersTable.put(aUser.getId(), aUser);
				usersTable.remove(dUser.getId());
				SaveUsersTable(usersTable);
			}else{
				System.out.println("user doesn't exists to delete , user defined exception will be raised soon......");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return dUser;
	}
	
	
	/*public User getUserBy(int id){
		List<User> allUsers = getUsers();
		System.out.println("total users list = " + allUsers.size());
		for(User au:allUsers)
		{
			System.out.println("checking with "+au.getId());
			if (au.getId() == id){return au;}else{return null;}
		}
		return null;
	}*/
	
	public User getUserBy(int id){
		Hashtable<Integer,User> usersTable = getUsersTable();
		return usersTable.get(id);
	}
	
}