package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableDemo2 {
 private int id,age;
 private String Classes,name;
 
	
	public CallableDemo2() {
	super();
}


	public CallableDemo2(int id, int age, String class1, String name) {
	super();
	this.id = id;
	this.age = age;
	Classes = class1;
	this.name = name;
}


	public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public String getClasses() {
	return Classes;
}


public void setClass(String class1) {
	Classes = class1;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			CallableStatement cs=con.prepareCall("call setstudnet(?,?,?,?)");
			Scanner s=new Scanner(System.in);
			System.out.println("Enter ID:");
			int id=s.nextInt();
			System.out.println("Enter Name:");
			String name=s.next();
			System.out.println("Enter Class:");
			String c=s.next();
			System.out.println("Enter age:");
			int age=s.nextInt();
			
			cs.setInt(1, id);
			cs.setString(2, name);
			cs.setString(3, c);
			cs.setInt(4, age);
			CallableDemo2 cd=new CallableDemo2(id,age,c,name);
			
			int n=cs.executeUpdate();

			if(n>0)
			{
				System.out.println("Data inserted successfully");
			}
			else {
				System.out.println("Data not inserted");
			}
			
			cs=con.prepareCall("call getstudent()");
			ResultSet rs=cs.executeQuery();
			
			while(rs.next())
			{
				System.out.println("ID:"+rs.getInt(1)+"Name:"+rs.getString(2)+"Class:"+rs.getString(3)+"Age"+rs.getInt(4));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
