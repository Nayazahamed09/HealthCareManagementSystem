package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC {
	public static void main(String[] args) throws Throwable {
		Connection con=null;
		
		try {
			//1. REGISTER THE DRIVER
			
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			
			//2. GET CONNECTION FOR DATABASE
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TestYantra", "root", "root");		
			//3. CREATE STATEMENT
			 Statement state=con.createStatement();
			 String Query="insert into TYSS values('akhil','manual',1),('SHRUTHI','JAVA',1);";
			
			//4 EXECUTE/UPDATE
			int result = state.executeUpdate(Query);
			
			if(result>=1)
			{
				System.out.println("Data added successfully");
			}
			else
			{
				System.out.println("-----data not added---");
			}
			
		}
		catch(Exception e)
		{
			
		}
		finally {
			//5 CLOSE DB:
			con.close();
		}
			
		
	}
}
			
		
		
		
		
		
	


		
		
	
	
	
	

