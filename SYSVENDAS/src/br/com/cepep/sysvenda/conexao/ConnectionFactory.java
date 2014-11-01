package br.com.cepep.sysvenda.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException{
		try {
			if(connection == null){
				connection = DriverManager.getConnection("jdbc:mysql://localhost/loja?user=root&password=root");
			}
			
			return connection;
			
		} catch (SQLException e) {
			System.err.println("Falha ao estabelecer conexão");
			throw e;
		}
	}

}
