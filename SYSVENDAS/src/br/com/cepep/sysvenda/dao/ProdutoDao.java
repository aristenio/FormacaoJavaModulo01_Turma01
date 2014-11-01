package br.com.cepep.sysvenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cepep.sysvenda.conexao.ConnectionFactory;
import br.com.cepep.sysvenda.entidades.Produto;

public class ProdutoDao {
	
	private Connection connection;
	
	public ProdutoDao() {
		try {
			connection = ConnectionFactory.getConnection();
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

	public Produto consultarPorNome(String nome) throws SQLException {
		String sql = "SELECT * FROM PRODUTOS WHERE NOME LIKE ?";
		Produto produto = new Produto();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet resultSet = stmt.executeQuery();
			
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
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return produto;
	}

	public void atualizar(Produto produto) throws SQLException {
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
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
