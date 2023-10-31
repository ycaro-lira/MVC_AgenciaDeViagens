package model;

 

import java.sql.Connection;

import java.sql.DriverManager;

 

public class Conexao {

 

	private static final String USERNAME = "ycarolira";

 

	private static final String PASSWORD = "ycaro";

 

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenciadeviagens";

 

	public static Connection createConnectionToMySQL() throws Exception {

 

		Class.forName("com.mysql.cj.jdbc.Driver");

 
	

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

 

		return connection;

	}

}