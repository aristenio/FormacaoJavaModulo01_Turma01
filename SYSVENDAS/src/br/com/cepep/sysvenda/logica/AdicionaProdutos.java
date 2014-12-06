package br.com.cepep.sysvenda.logica;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cepep.sysvenda.dao.ProdutoDao;
import br.com.cepep.sysvenda.entidades.Produto;

public class AdicionaProdutos implements Logica{
    
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Connection connection = (Connection) request.getAttribute("connection");
		ProdutoDao produtoDao = new ProdutoDao(connection);
		
		System.out.println("Entrou no método adicina");
		
		Produto produto = new Produto();
		
		produto.setNome(request.getParameter("nome"));
		produto.setDescricaoGrande(request.getParameter("descricao"));
		produto.setDescricaoPequena(request.getParameter("descricaoReduzida"));
		produto.setPreco(Double.valueOf(request.getParameter("preco")));
		produto.setPrecoDesconto(Double.valueOf(request.getParameter("precoDesconto")));
		produto.setDesconto(Float.valueOf(request.getParameter("desconto")));
		produto.setImagem(request.getParameter("imagem"));
		
		try {
			produtoDao.inserir(produto);
			System.out.println("salvou o produto");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/produtoInseridoSucesso.jsp");
		requestDispatcher.forward(request, response);
	}
	
}
