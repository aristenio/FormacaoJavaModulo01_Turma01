package br.com.cepep.sysvenda.servlets;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.sysvenda.dao.ProdutoDao;
import br.com.cepep.sysvenda.entidades.Produto;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDao produtoDao;
	
	@RequestMapping("cadastrarProdutos")
	public String cadastrarProduto(){
		return "produtos/cadastrar";
	}
	
	@RequestMapping("editarProdutos")
	public String editarProdutos(Long id, Model model){
		
		try {
			Produto produto = produtoDao.consultarProduto(id);
			model.addAttribute("produtos", produto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "produtos/editar";
	}

	@RequestMapping("inserirProdutos")
	public String inserirProduto(@Validated Produto produto){
		
		try {
			produtoDao.inserir(produto);			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "produtos/inseridoOk";
	}
	
	@RequestMapping("atualizarProduto")
	public String atualizarProduto(Produto produto){
		try {
			produtoDao.atualizarProduto(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "forward:listarProdutos";
	}
	
	@RequestMapping("listarProdutos")
	public String listarProdutos(Model model){
		
		try {
			List<Produto> listarProdutos = produtoDao.listarProdutos();
			model.addAttribute("produtos", listarProdutos);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "produtos/lista";
	}
	
	@RequestMapping("removerProdutos")
	public String removerProduto(Produto produto){
		
		try {
			produtoDao.removerProduto(produto.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "forward:listarProdutos";
	}
}
