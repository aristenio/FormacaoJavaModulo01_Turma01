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

import br.com.cepep.sysvenda.entidades.ItemPedido;
import br.com.cepep.sysvenda.entidades.Produto;

@Repository
public class ItensPedidoDao {

	private Connection connection;

	@Autowired
	private ProdutoDao produtoDao;

	@Autowired
	public ItensPedidoDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ItemPedido inserir(ItemPedido itemPedido) throws SQLException {
		String sql = "INSERT INTO ITENS_PEDIDO (ID_PEDIDO,ID_PRODUTO,QTD,PRECO) VALUES (?,?,?,?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, itemPedido.getIdPedido());
			statement.setLong(2, itemPedido.getProduto().getId());
			statement.setInt(3, itemPedido.getQuantidade());
			statement.setDouble(4, itemPedido.getPreco());

			statement.execute();
			statement.close();

			return itemPedido;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public ItemPedido consultar(ItemPedido itemPedido) throws SQLException {
		String sql = "SELECT * FROM ITENS_PEDIDO WHERE ID_PEDIDO=?, ID_PRODUTO=?, QTD=?, PRECO=?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			ItemPedido itemPedidoRetorno = null;
			while (resultSet.next()) {
				itemPedidoRetorno = new ItemPedido();
				itemPedidoRetorno.setIdPedido(resultSet.getLong("ID_PEDIDO"));
				itemPedidoRetorno.setPreco(resultSet.getDouble("PRECO"));
				itemPedidoRetorno.setQuantidade(resultSet.getInt("QTD"));

				Produto produto = produtoDao.consultarProduto(resultSet
						.getLong("ID_PRODUTO"));
				itemPedidoRetorno.setProduto(produto);
			}

			return itemPedidoRetorno;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<ItemPedido> consultarItensPedido(Long id) throws SQLException {
		String sql = "SELECT * FROM ITENS_PEDIDO WHERE ID_PEDIDO=?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();

			List<ItemPedido> retorno = new ArrayList<>();
			
			while (resultSet.next()) {
				ItemPedido itemPedido = new ItemPedido();
				itemPedido.setIdPedido(resultSet.getLong("ID_PEDIDO"));
				itemPedido.setPreco(resultSet.getDouble("PRECO"));
				itemPedido.setQuantidade(resultSet.getInt("QTD"));

				Produto produto = produtoDao.consultarProduto(resultSet
						.getLong("ID_PRODUTO"));
				itemPedido.setProduto(produto);
				retorno.add(itemPedido);
			}

			return retorno;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}

}
