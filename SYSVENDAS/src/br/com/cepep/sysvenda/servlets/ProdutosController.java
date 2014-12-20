package br.com.cepep.sysvenda.servlets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.sysvenda.dao.ProdutoDao;
import br.com.cepep.sysvenda.entidades.Produto;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDao produtoDao;
	
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
}
