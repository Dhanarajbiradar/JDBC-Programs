package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			Statement s=con.createStatement();
			int n=s.executeUpdate("insert into student values(6,\"Dhanraj\",\"BCA\",12)");
			
			if(n>0)
			{
				System.out.println("Data inserted successfully");
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
