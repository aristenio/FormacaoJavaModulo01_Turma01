package br.com.cepep.sysvenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cepep.sysvenda.entidades.Cliente;
import br.com.cepep.sysvenda.entidades.ItemPedido;
import br.com.cepep.sysvenda.entidades.Pedido;

@Repository
public class PedidoDao {
	
	private Connection connection;
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private ItensPedidoDao itensPedidoDao;
	
	@Autowired
	public PedidoDao(DataSource dataSource){
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Pedido inserir(Pedido pedido) throws SQLException{
		String sql = "INSERT INTO PEDIDOS (ID_CLIENTE,DATA_PEDIDO,VALOR_TOTAL) VALUES (?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, pedido.getCliente().getId());
			statement.setDate(2, new Date(pedido.getData().getTime()));
			statement.setDouble(3, pedido.getValorTotal());
			
			statement.execute();
			statement.close();
			
			Pedido pedidoInserido =  this.consultarPedido(pedido);
			
			List<ItemPedido> itensPedido = pedido.getItensPedido();
			for (ItemPedido itemPedido : itensPedido) {
				itemPedido.setIdPedido(pedidoInserido.getId());
				itensPedidoDao.inserir(itemPedido);
			}
			
			pedidoInserido.setIntensPedido(itensPedido);
			
			return pedidoInserido;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Pedido consultarPedido(Pedido pedido) throws SQLException{
		String sql = "SELECT * FROM PEDIDOS WHERE ID_CLIENTE=? AND DATA_PEDIDO=? AND VALOR_TOTAL=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, pedido.getCliente().getId());
			preparedStatement.setDate(2, new Date(pedido.getData().getTime()));
			preparedStatement.setDouble(3, pedido.getValorTotal());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Pedido pedidoRetorno = new Pedido();
			while (resultSet.next()) {
				pedidoRetorno.setId(resultSet.getLong("ID"));
				pedidoRetorno.setData(resultSet.getDate("DATA_PEDIDO"));
				pedidoRetorno.setValorTotal(resultSet.getDouble("VALOR_TOTAL"));
				
				Cliente cliente = clienteDao.consultarCliente(resultSet.getLong("ID_CLIENTE"));
				pedidoRetorno.setCliente(cliente);
			}
			return pedidoRetorno;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public List<Pedido> consultarPedidos() throws SQLException{
		String sql = "SELECT * FROM PEDIDOS";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		List<Pedido> retorno = new ArrayList<>();
		
		while (resultSet.next()){
			Pedido pedido = new Pedido();
			pedido.setId(resultSet.getLong("ID"));
			pedido.setData(resultSet.getDate("DATA_PEDIDO"));
			pedido.setValorTotal(resultSet.getDouble("VALOR_TOTAL"));
			
			Cliente cliente = clienteDao.consultarCliente(resultSet.getLong("ID_CLIENTE"));
			pedido.setCliente(cliente);
			List<ItemPedido> intensPedido = itensPedidoDao.consultarItensPedido(pedido.getId());
			pedido.setIntensPedido(intensPedido);
			retorno.add(pedido);
		}
		
		return retorno;
	}

}
