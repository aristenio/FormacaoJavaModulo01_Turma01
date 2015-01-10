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
import br.com.cepep.sysvenda.entidades.Usuario;

@Repository
public class UsuarioDAO {

	private Connection connection;

	@Autowired
	public UsuarioDAO(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario existeUsuario(String login, String senha) {
		String sql = "select * from usuarios where login=? and senha=?";
		Usuario usuario = null;

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
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

	public List<Usuario> listarUsuarios() throws SQLException {
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

	public Usuario inserir(Usuario usuario) throws SQLException {
		String sql = "INSERT USUARIOS (LOGIN,SENHA,NOME) VALUES (?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getNome());
			stmt.execute();
			stmt.close();

			return usuario;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void remover(Long id) throws SQLException {
		String sql = "DELETE FROM USUARIOS WHERE ID = ?";

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

	public Usuario atualizar(Usuario usuario) throws SQLException {
		String sql = "UPDATE USUARIOS SET NOME=?,LOGIN=?,SENHA=? WHERE ID=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.setLong(4, usuario.getId());

			stmt.execute();
			stmt.close();

			return usuario;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Usuario consultarUsuario(Long id) throws SQLException {

		String sql = "SELECT * FROM USUARIOS WHERE ID=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultSet = stmt.executeQuery();

			Usuario cliente = new Usuario();
			while (resultSet.next()) {
				cliente.setId(resultSet.getLong("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setLogin(resultSet.getString("login"));
				cliente.setSenha(resultSet.getString("senha"));
			}

			return cliente;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
