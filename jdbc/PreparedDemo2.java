package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedDemo2 {
	private int id,age;
	private String name,city;
	
	
	public PreparedDemo2() {
		super();
	}


	public PreparedDemo2(int id, int age, String name, String city) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.city = city;
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			PreparedStatement ps=con.prepareStatement("insert into employee values (?,?,?,?)");
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Empoyee ID:");
			int id=s.nextInt();
			System.out.println("Enter Empoyee Name:");
			String name=s.next();
			System.out.println("Enter Employee Age:");
			int age=s.nextInt();
			System.out.println("Enter Employee City:");
			String city=s.next();
			
			PreparedDemo2 pr=new PreparedDemo2(id,age,name,city);
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setInt(3, age);
			ps.setString(4, city);
			int n=ps.executeUpdate();
			if(n>0)
			{
				System.out.println("Data inserted successfully");
			}
			else {
				System.out.println("Data not inserted");
			}
			
			ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("ID: "+rs.getInt(1)+" Name:"+rs.getString(2)+" Age:"+rs.getInt(3)+" City:"+rs.getString(4));
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
