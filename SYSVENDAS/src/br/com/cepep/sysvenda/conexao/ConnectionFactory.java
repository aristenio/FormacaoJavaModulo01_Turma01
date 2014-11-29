package br.com.cepep.sysvenda.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection;
	
	public static Connection getConnection() throws Exception{
		try {
			if(connection == null){
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/loja?user=root&password=root");
			}
			
			return connection;
			
		} catch (SQLException e) {
			System.err.println("Falha ao estabelecer conexão");
			throw e;
		} catch (ClassNotFoundException e) {
			System.err.println("Falha ao carregar o driver de conexão");
			e.printStackTrace();
			throw e;
		}
	}

}
