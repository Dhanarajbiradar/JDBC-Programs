package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			PreparedStatement ps=con.prepareStatement("insert into student values (?,?,?,?)");
			ps.setInt(1, 101);
			ps.setString(2,"Santosh");
			ps.setString(3,"B.com");
			ps.setInt(4, 19);
			
			int n=ps.executeUpdate();
			
			if(n>0)
			{
				System.out.println("Data inserted successfully");
			}
			else {
				System.out.println("Data not inserted");
			}
			ps=con.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("ID:"+rs.getInt(1)+"Name:"+rs.getString(2)+"Class:"+rs.getString(3)+"Age"+rs.getInt(4));
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		stored procedure in mysql
	}

}
