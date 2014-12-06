package com.br.cepep.sysvendas.dao;

import static org.junit.Assert.fail;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import br.com.cepep.sysvenda.dao.ProdutoDao;
import br.com.cepep.sysvenda.entidades.Produto;

public class TesteProdutoDAO {

	private ProdutoDao dao;
	
	@Before
	public void init(){
//		dao = new ProdutoDao();
	}
	
	@Test
	public void testeInserir(){
		Produto produto = new Produto();
		produto.setNome("Pêra");
		produto.setPreco(5.20);
		produto.setPrecoDesconto(5.20);
		produto.setDesconto(0.0F);
		produto.setDescricaoPequena("Pêra");
		produto.setDescricaoGrande("Pêra boa");
		produto.setImagem(null);
		
		try {
			dao.inserir(produto);
		} catch (SQLException e) {
			fail("Falha no teste de inserção");
		}
	}
	
	@Test
	public void testeConsultarPorNome(){
		Produto produto = new Produto();
		produto.setNome("Manga");
		produto.setPreco(4.50);
		produto.setPrecoDesconto(4.50);
		produto.setDesconto(0.0F);
		produto.setDescricaoPequena("Manga");
		produto.setDescricaoGrande("Manga boa");
		produto.setImagem(null);

		try {
			dao.inserir(produto);
		} catch (SQLException e) {
			fail("Falha no teste de inserção");
		}
		
		Produto produtoNovo = new Produto();
		try {
			produtoNovo = dao.consultarPorNome(produto.getNome());
		} catch (SQLException e) {
			fail("Falha no teste de consulta");
		}
		assertNotNull(produtoNovo);
		assertEquals(produto.getNome(), produtoNovo.getNome());
		assertEquals(produto.getPreco(), produtoNovo.getPreco());
	}
	
	@Test
	public void testAtualizar(){
		Produto produto = new Produto();
		produto.setNome("Melancia");
		produto.setPreco(8.50);
		produto.setPrecoDesconto(8.50);
		produto.setDesconto(0.0F);
		produto.setDescricaoPequena("Melancia");
		produto.setDescricaoGrande("Melancia boa");
		produto.setImagem(null);

		try {
			dao.inserir(produto);
		} catch (SQLException e) {
			fail("Falha no teste de inserção");
		}
		
		Produto produtoAtualizar = new Produto();
		try {
			produtoAtualizar = dao.consultarPorNome(produto.getNome());
		} catch (SQLException e) {
			fail("Falha no teste de consulta");
		}
		
		produtoAtualizar.setPreco(12.50);
		
		try {
			dao.atualizar(produtoAtualizar);
		} catch (SQLException e) {
			fail("Falha no teste de consulta");
		}
		
		Produto produtoAtualizado = new Produto();
		try {
			produtoAtualizado = dao.consultarPorNome(produto.getNome());
		} catch (SQLException e) {
			fail("Falha no teste de consulta");
		}
		
		assertEquals(produtoAtualizar.getPreco(), produtoAtualizado.getPreco());
	}
	

}
