package com.cepep.formacaojava.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCOperacoes {
	public static void main(String[] args) {
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/escola?user=root&password=root");
			
			String sql = "INSERT INTO ALUNO (NOME,EMAIL,TELEFONE,ALTURA,APROVADO,SEXO,CIDADE,CPF) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, "aluno");
			ps.setString(2, "aluno@email");
			ps.setString(3, "654654654");
			ps.setDouble(4, 1.70);
			ps.setBoolean(5, true);
			ps.setString(6, "M");
			ps.setString(7, "Fortaleza");
			ps.setString(8, "45678912345");
			
			ps.execute();

			conexao.close();
		} catch (SQLException e) {
			System.out.println("Falha na conexão");
			e.printStackTrace();
		}	
	}
}
