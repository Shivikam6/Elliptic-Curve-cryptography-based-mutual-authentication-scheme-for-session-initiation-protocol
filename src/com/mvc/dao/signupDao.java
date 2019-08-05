package com.mvc.dao;

import java.sql.*;

import com.mvc.bean.signupBean;
import com.mvc.util.*;

public class signupDao {

	
	public static Connection conn = null; 
    static PreparedStatement pstmt = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;
    String usernameDB ="";
    
    
    public void userRegister(String username, String firstname,String lastname, String password, byte[] R1)
    {     
        try
        {
        		conn = DBConnection.createConnection();
      
            	String query="insert into users(`username`,`firstname`,`lastname`,`password`, `R1`) "
                        + "values('"+username+"','"+firstname+"','"+lastname+"','"+password+"','"+R1+"')";
            	
               	pstmt=conn.prepareStatement(query);
            	pstmt.executeUpdate();
            	System.out.println("record inserted successfully");       
             
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }        
    }
    
    public String checkUserNameAvailable(signupBean signupbean) {
		// Return true if user name available else false
    		String username = signupbean.getUsername();
		try {
			conn = DBConnection.createConnection(); // establishing connection
			statement = conn.createStatement(); // Statement is used to write queries. Read more about it.
			String query = "select username from users where username='" + username + "'";
			System.out.println(query);
			resultSet = statement.executeQuery(query) ;
			
			resultSet = statement.executeQuery("select username from users where (username = '" + username + "')");
			System.out.println("user name string running");
			while (resultSet.next()) {
				usernameDB = resultSet.getString("username");
				System.out.println("data from bean"+username);
				System.out.println("Data from Database"+usernameDB);
				if (username.equals(usernameDB)) {
					System.out.println("in if loop");
					return "DUPLICATE";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("user name string running returns true");
		return "Valid credentials";
	}
   
}
