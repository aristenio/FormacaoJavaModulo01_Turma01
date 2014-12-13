package br.com.cepep.sysvenda.dao;

import java.sql.Connection;

public class UsuarioDAO {
	
	private Connection connection;
	
	public UsuarioDAO(Connection connection){
		this.connection = connection;
	}
	
	public boolean existeUsuario(Long id){
		return true;
	}

}
