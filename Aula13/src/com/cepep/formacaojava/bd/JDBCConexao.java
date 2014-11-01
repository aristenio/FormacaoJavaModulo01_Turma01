package com.cepep.formacaojava.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConexao {
	
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/escola?user=root&password=root2");
			System.out.println("Connected");
		} catch (SQLException e) {
			System.out.println("Not connect. "+e.getMessage());
		}
	}

}
