package br.com.cepep.sysvenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cepep.sysvenda.entidades.Cliente;
import br.com.cepep.sysvenda.entidades.Produto;

public class ClienteDao {
	
	private Connection connection;
	
	public ClienteDao(Connection connection){
		this.connection = connection; 
	}
	
	public Cliente inserir(Cliente cliente) throws SQLException{
		String sql = "INSERT CLIENTES (NOME,EMAIL,ENDERECO,BAIRRO,CIDADE,"
				+ "ESTADO,CEP) VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getBairro());
			stmt.setString(5, cliente.getCidade());
			stmt.setString(6, cliente.getEstado());
			stmt.setString(7, cliente.getCep());
			
			stmt.execute();
			stmt.close();
			
			return cliente;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<Cliente> listarClientes() throws SQLException{
		List<Cliente> retorno = new ArrayList<>();
		
		String sql = "SELECT * FROM CLIENTES";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getLong("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("preco"));
				cliente.setEndereco(resultSet.getString("preco"));
				cliente.setBairro((resultSet.getString("preco_desc"));
				cliente.setCidade(resultSet.getString("desconto"));
				cliente.setEstado(resultSet.getString("desc_pqna"));
				cliente.setCep(resultSet.getString("desc_gnd"));
				
				retorno.add(cliente);
			}
			
			return retorno;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}


}
