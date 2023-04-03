package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo2 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			Statement s=con.createStatement();
		int n=s.executeUpdate("insert into employee values(15,\"Dhanraj\",23,\"Latur\")");
		if(n>0)
		{
			System.out.println("Data inserted successfully");
			
		}
		else
		{
			System.out.println("Data not inserted");
			
		}
		ResultSet rs=s.executeQuery("select*from employee");
		while(rs.next())
		{
			System.out.println("Id"+rs.getInt(1)+"Name"+rs.getString(2)+"Age"+rs.getInt(3)+"City"+rs.getString(4));
		}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
