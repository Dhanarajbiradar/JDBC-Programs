package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementDemo1 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			CallableStatement cs=con.prepareCall("call setstudnet(?,?,?,?)");
			cs.setInt(1, 205);
			cs.setString(2, "Tukaram");
			cs.setString(3, "MCA");
			cs.setInt(4, 20);
			
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
