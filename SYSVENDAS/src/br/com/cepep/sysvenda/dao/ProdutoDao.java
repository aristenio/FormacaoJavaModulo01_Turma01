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

import br.com.cepep.sysvenda.entidades.Cliente;
import br.com.cepep.sysvenda.entidades.Produto;

@Component
public class ProdutoDao {
	
	private Connection connection;
	
	@Autowired
	public ProdutoDao(DataSource dataSource){
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public Produto inserir(Produto produto) throws SQLException{
		String sql = "INSERT PRODUTOS (NOME,PRECO,PRECO_DESC,DESCONTO,DESC_PQNA,"
				+ "DESC_GND,IMAGEM) VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setDouble(3, produto.getPrecoDesconto());
			stmt.setFloat(4, produto.getDesconto());
			stmt.setString(5, produto.getDescricaoPequena());
			stmt.setString(6, produto.getDescricaoGrande());
			stmt.setString(7, produto.getImagem());
			
			stmt.execute();
			stmt.close();
			
			return produto;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<Produto> listarProdutos() throws SQLException{
		List<Produto> retorno = new ArrayList<>();
		
		String sql = "SELECT * FROM PRODUTOS";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				Produto produto = new Produto();
				produto.setId(resultSet.getLong("id"));
				produto.setNome(resultSet.getString("nome"));
				produto.setPreco(resultSet.getDouble("preco"));
				produto.setPrecoDesconto(resultSet.getDouble("preco_desc"));
				produto.setDesconto(resultSet.getFloat("desconto"));
				produto.setDescricaoPequena(resultSet.getString("desc_pqna"));
				produto.setDescricaoGrande(resultSet.getString("desc_gnd"));
				produto.setImagem(resultSet.getString("imagem"));
				produto.setQuantidadeEstoque(resultSet.getInt("qtd_estoque"));
				
				retorno.add(produto);
			}
			
			return retorno;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void removerProduto(Long id) throws SQLException {
		String sql = "DELETE FROM PRODUTOS WHERE ID=?";
		
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
	
	public Produto consultarProduto(Long id) throws SQLException {
		
		String sql = "SELECT * FROM PRODUTOS WHERE ID=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultSet = stmt.executeQuery();
			
			Produto produto = new Produto();
			while (resultSet.next()) {
				produto.setId(resultSet.getLong("id"));
				produto.setNome(resultSet.getString("nome"));
				produto.setPreco(resultSet.getDouble("preco"));
				produto.setPrecoDesconto(resultSet.getDouble("preco_desc"));
				produto.setDesconto(resultSet.getFloat("desconto"));
				produto.setDescricaoPequena(resultSet.getString("desc_pqna"));
				produto.setDescricaoGrande(resultSet.getString("desc_gnd"));
				produto.setImagem(resultSet.getString("imagem"));
				produto.setQuantidadeEstoque(resultSet.getInt("qtd_estoque"));
			}
			
			return produto;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	public Produto atualizarProduto(Produto produto) throws SQLException {
		String sql = "UPDATE PRODUTOS SET NOME=?,PRECO=?,PRECO_DESC=?,DESCONTO=?,DESC_PQNA=?"
				+ ",DESC_GND=?,IMAGEM=? WHERE ID=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setDouble(3, produto.getPrecoDesconto());
			stmt.setFloat(4, produto.getDesconto());
			stmt.setString(5, produto.getDescricaoPequena());
			stmt.setString(6, produto.getDescricaoGrande());
			stmt.setString(7, produto.getImagem());
			stmt.setLong(8, produto.getId());
			
			stmt.execute();
			stmt.close();
			
			return produto;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
