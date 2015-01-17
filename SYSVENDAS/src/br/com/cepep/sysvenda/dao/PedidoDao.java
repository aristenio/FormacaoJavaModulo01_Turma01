package br.com.cepep.sysvenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cepep.sysvenda.entidades.Cliente;
import br.com.cepep.sysvenda.entidades.Pedido;

@Repository
public class PedidoDao {
	
	private Connection connection;
	
	@Autowired
	private ClienteDao clienteDao;
	
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
			statement.setDate(2, (Date) pedido.getData());
			statement.setDouble(3, pedido.getValorTotal());
			
			statement.execute();
			statement.close();
			
			return this.consultarPedido(pedido);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Pedido consultarPedido(Pedido pedido) throws SQLException{
		String sql = "SELECT * FROM PEDIDOS WHERE ID_CLIENTE=? AND DATA_PEDIDO=? AND VALOR_TOTAL=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Pedido pedidoRetorno = new Pedido();
			while (resultSet.next()) {
				pedidoRetorno.setId(resultSet.getLong("ID"));
				pedidoRetorno.setData(resultSet.getDate("DATA_PEDIDO"));
				pedidoRetorno.setValorTotal(resultSet.getDouble("VALOR_TOTAL"));
				
				Cliente cliente = clienteDao.consultarCliente(resultSet.getLong("ID_CLIENTE"));
				pedido.setCliente(cliente);
			}
			return pedido;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
	}

}
