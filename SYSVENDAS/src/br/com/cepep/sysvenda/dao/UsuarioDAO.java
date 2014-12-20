package br.com.cepep.sysvenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cepep.sysvenda.entidades.Usuario;

public class UsuarioDAO {
	
	private Connection connection;
	
	public UsuarioDAO(Connection connection){
		this.connection = connection;
	}
	
	public Usuario existeUsuario(String login, String senha){
		String sql = "select * from usuarios where login=? and senha=?";
		Usuario usuario = null;

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet resultSet = stmt.executeQuery();
			
			if(resultSet.next()){
				usuario = new Usuario();
				usuario.setNome(resultSet.getString("nome"));
				usuario.setLogin(resultSet.getString("login"));
				usuario.setSenha(resultSet.getString("senha"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
}
