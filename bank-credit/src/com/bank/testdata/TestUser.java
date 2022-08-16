package com.bank.testdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.user.User;
import com.google.gson.Gson;

public class TestUser {
	
	public String getTestUsers(){
		List<User> users = new ArrayList<User>();	
		
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println("Fail");
		}
		
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Password")) {
			 
            System.out.println("Java JDBC PostgreSQL Example");	        	 
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();	           
            ResultSet resultSet = statement.executeQuery("SELECT id, student_phone, student_name\r\n"
            		+ "	FROM bank.student;");
            while (resultSet.next()) {
            	users.add(new User (resultSet.getString("student_name"), resultSet.getString("student_phone")));
            }
 
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }	
		
		Gson gson = new Gson();		
		return gson.toJson(users);	
	}

}
