package br.com.cepep.sysvenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.cepep.sysvenda.entidades.Cliente;

@Component
public class ClienteDao {
	
	private Connection connection;
	
	@Autowired
	public ClienteDao(DataSource dataSource){
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public Cliente inserir(Cliente cliente) throws SQLException{
		String sql = "INSERT CLIENTES (NOME,EMAIL,ENDERECO,BAIRRO,CIDADE,"
				+ "ESTADO,CEP,ATIVO) VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getBairro());
			stmt.setString(5, cliente.getCidade());
			stmt.setString(6, cliente.getEstado());
			stmt.setString(7, cliente.getCep());
			stmt.setBoolean(8, cliente.getAtivo());
			
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
				cliente.setEmail(resultSet.getString("email"));
				cliente.setEndereco(resultSet.getString("endereco"));
				cliente.setBairro(resultSet.getString("bairro"));
				cliente.setCidade(resultSet.getString("cidade"));
				cliente.setEstado(resultSet.getString("estado"));
				cliente.setCep(resultSet.getString("cep"));
				cliente.setAtivo(resultSet.getBoolean("ativo"));
				retorno.add(cliente);
			}
			
			return retorno;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void removerCliente(Long id) throws SQLException {
		String sql = "DELETE FROM CLIENTES WHERE ID=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void atualizaStatusCliente(Long id, boolean ativo) throws SQLException{
		String sql = "UPDATE CLIENTES SET ATIVO=? WHERE ID=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, ativo);
			stmt.setLong(2, id);
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	public Cliente consultarCliente(Long id) throws SQLException {
		
		String sql = "SELECT * FROM CLIENTES WHERE ID=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultSet = stmt.executeQuery();
			
			Cliente cliente = new Cliente();
			while (resultSet.next()) {
				cliente.setId(resultSet.getLong("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setEndereco(resultSet.getString("endereco"));
				cliente.setBairro(resultSet.getString("bairro"));
				cliente.setCidade(resultSet.getString("cidade"));
				cliente.setEstado(resultSet.getString("estado"));
				cliente.setCep(resultSet.getString("cep"));
				cliente.setAtivo(resultSet.getBoolean("ativo"));
			}
			
			return cliente;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Cliente atualizarCliente(Cliente cliente) throws SQLException {
		String sql = "UPDATE CLIENTES SET NOME=?,EMAIL=?,ENDERECO=?,BAIRRO=?,CIDADE=?,"
				+ "ESTADO=?,CEP=?,ATIVO=? WHERE ID=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getBairro());
			stmt.setString(5, cliente.getCidade());
			stmt.setString(6, cliente.getEstado());
			stmt.setString(7, cliente.getCep());
			stmt.setBoolean(8, cliente.getAtivo());
			stmt.setLong(9, cliente.getId());
			
			stmt.execute();
			stmt.close();
			
			return cliente;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}


}
