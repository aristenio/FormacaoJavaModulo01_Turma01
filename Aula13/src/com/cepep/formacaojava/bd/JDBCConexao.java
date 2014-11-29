package com.cepep.formacaojava.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConexao {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja?user=root&password=root");
			System.out.println("Connected");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Not connect. "+e.getMessage());
		}
	}

}
