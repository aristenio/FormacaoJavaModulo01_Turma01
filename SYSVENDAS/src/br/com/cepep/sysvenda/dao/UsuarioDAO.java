package br.com.cepep.sysvenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cepep.sysvenda.entidades.Usuario;
import br.com.cepep.sysvenda.entidades.Usuario;

@Repository
public class UsuarioDAO {
	
	private Connection connection;
	
	@Autowired
	public UsuarioDAO(DataSource dataSource){
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	public List<Usuario> listarUsuarios() throws SQLException{
		List<Usuario> retorno = new ArrayList<>();
		
		String sql = "SELECT * FROM USUARIOS";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getLong("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setLogin(resultSet.getString("login"));
								
				retorno.add(usuario);
			}
			
			return retorno;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
}
