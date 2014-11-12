package com.stu.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private final static String MYSQL="jdbc:mysql://localhost:3306/student";
	private final static String USERNAME="sehw";
	private final static String PASSWORD="mima";

	private static DBUtil instance = null;
	private Connection conn=null;

	private void DBUtil(){		
	}

	public static DBUtil getInstance(){
		if(instance==null){
			instance=new DBUtil();
		}return instance;
	}

	public boolean open(){
		try {
			conn=DriverManager.getConnection(MYSQL, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}

	public Connection getConnection(){
		if(conn==null){
			if(open()){
				System.out.println("----------Connection opened");				
				return conn;
			}else{
				return null;
			}
		}return conn;

	}

	public void close(){

		try {
			conn.close();
			conn=null;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection closed----------");
	}
}

