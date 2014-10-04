package com.cepep.formacaojava.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExemplo {
	public static void main(String[] args) {
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/escola?user=root&password=root");
			
			String sql = "select * from aluno";
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()){
				System.out.println(resultSet.getString("nome"));
				System.out.println(resultSet.getString("email"));
				System.out.println(resultSet.getString("telefone"));
				System.out.println(resultSet.getDouble("altura"));
			}
			
			resultSet.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Falha na conexão");
			e.printStackTrace();
		}
	}
}
