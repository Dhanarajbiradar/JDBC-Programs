package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentData {
	
	private static int id;
	private static int age;
	private static String name;
	private static String c;
	
	
	public StudentData() {
		super();
	}

	public StudentData(int id, int age, String name, String c) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.c = c;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public static void main(String[] args) {
		
		 StudentData sd=new StudentData();
//		 sd.setId(10);
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			Statement s=con.createStatement();
//			int n=s.executeUpdate("insert into student values(7,\"Dhanraj\",\"BCA\",12)");
			Scanner s1=new Scanner(System.in);
			
			System.out.println("Enter your id:");
			id=s1.nextInt();
			System.out.println("Enter your Name:");
			name=s1.next();
			System.out.println("Enter your Class:");
			c=s1.next();
			System.out.println("Enter your Age:");
			age=s1.nextInt();
		
			int n1=s.executeUpdate("insert into student values("+id+",\""+name+"\",\""+c+"\","+age+")");
			
			if(n1>0)
			{
				System.out.println("Data inserted successefully");
			}
			else {
				System.out.println("Data not inserted");
			}
			
			ResultSet rs=s.executeQuery("select*from student");
			
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
