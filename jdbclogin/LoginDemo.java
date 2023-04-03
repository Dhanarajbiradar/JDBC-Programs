package com.jdbclogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginDemo {
	private int id;
	private String Pass;
    
	public LoginDemo() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPass() {
		return Pass;
	}


	public void setPass(String pass) {
		Pass = pass;
	}


	public LoginDemo(int id, String pass) {
		super();
		this.id = id;
		Pass = pass;
	}


	public static void main(String[] args) {
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
		PreparedStatement ps=con.prepareStatement("insert into values(?,?)");
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Empoyee ID:");
		int id=s.nextInt();
		System.out.println("Enter Empoyee Password:");
		String name=s.next();
		
		LoginDemo ld=new LoginDemo(id, name);

		ResultSet rs=ps.executeQuery("select * from Login where id=1 and name='Dhanraj'");
		if(rs.getInt(1)==id && name.equals(rs.getString(2))) {
			System.out.println("Login sucesseful.");
			
		}
		else {
			System.out.println("login unsucessesful");
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
