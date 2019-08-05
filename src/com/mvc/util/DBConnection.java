package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBConnection {

	
	/*public static String ICSI518_DB_HOST = "localhost";
    public static String ICSI518_DB_PORT = "3306";
    public static String ICSI518_DB = "icsi518_hw2";
    public static String ICSI518_DB_USER = "icsi518";
    public static String ICSI518_DB_PASSWD = "secretICSI518";*/
	
	public static String ICSI518_DB_HOST = "localhost";
    public static String ICSI518_DB_PORT = "3306";
    public static String ICSI518_DB = "icsi518_hw2";
    public static String ICSI518_DB_USER = "icsi518";
    public static String ICSI518_DB_PASSWD = "secretICSI518";
	
	public static Connection createConnection()
	{
    	Connection connection=null;
    	try
    	{
    			Class.forName("com.mysql.jdbc.Driver");
    			//connection = DriverManager.getConnection(db_url,userName, password);
    			connection = DriverManager.getConnection("jdbc:mysql://" + ICSI518_DB_HOST + ":" + ICSI518_DB_PORT + "/" + ICSI518_DB,ICSI518_DB_USER, ICSI518_DB_PASSWD);
    			System.out.println("Printing connection object "+connection);
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	return connection;
    }
   
}
