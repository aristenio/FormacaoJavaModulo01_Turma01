package br.com.cepep.sysvenda.servlets;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.sysvenda.dao.ClienteDao;
import br.com.cepep.sysvenda.dao.PedidoDao;
import br.com.cepep.sysvenda.dao.ProdutoDao;
import br.com.cepep.sysvenda.entidades.Cliente;
import br.com.cepep.sysvenda.entidades.ItemPedido;
import br.com.cepep.sysvenda.entidades.Pedido;
import br.com.cepep.sysvenda.entidades.Produto;

@Controller
public class PedidosController {
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private ProdutoDao produtoDao;
	
	@Autowired
	private PedidoDao pedidoDao;
	
	@RequestMapping("pedido")
	public String pedido(){
		return "pedidos/pedido";
	}
	
	@RequestMapping("consultarClientePedido")
	public String consultarClientePedido(Long idCliente, HttpSession sessao) throws Exception{
		try {
			Cliente cliente = clienteDao.consultarCliente(idCliente);
			sessao.setAttribute("clientePedido", cliente);
			
			return "pedidos/pedido";
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@RequestMapping("consultarProdutoPedido")
	public String consultarProdutoPedido(Long idProduto, HttpSession sessao) throws Exception{
		try {
			Produto produto = produtoDao.consultarProduto(idProduto);
			sessao.setAttribute("produtoPedido", produto);
			
			return "pedidos/pedido";
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@RequestMapping("adicionarProdutoPedido")
	public String adicionarProdutoPedido(HttpSession sessao) throws Exception{
		try {
			List<ItemPedido> itensPedido = null;
			
			if(sessao.getAttribute("itensPedido") != null){
				itensPedido = (List<ItemPedido>) sessao.getAttribute("itensPedido");
			}else
				itensPedido = new ArrayList<>();
				
			Produto produtoSessao = (Produto) sessao.getAttribute("produtoPedido");

			if(sessao.getAttribute("produtoPedido") != null){
				ItemPedido itemPedido = new ItemPedido();
				itemPedido.setProduto(produtoSessao);
				itemPedido.setQuantidade(1);
				itemPedido.setPreco(produtoSessao.getPreco()*itemPedido.getQuantidade());
				
				boolean novo = true;
				for(ItemPedido item : itensPedido){
					if(produtoSessao.getId().equals(item.getProduto().getId())){
						novo = false;
						item.setQuantidade(item.getQuantidade()+1);
						item.setPreco(item.getPreco()+produtoSessao.getPreco());
					}
				}
				
				if(novo){
					itensPedido.add(itemPedido);
				}
				
			}
			
			sessao.setAttribute("itensPedido", itensPedido);
			sessao.removeAttribute("produtoPedido");
			
			return "pedidos/pedido";
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@RequestMapping("efetuarPedido")
	public String efetuarPedido(HttpSession session) throws Exception{
		
		try {
			Cliente cliente = (Cliente) session.getAttribute("clientePedido");
			List<ItemPedido> intensPedido = (List<ItemPedido>) session.getAttribute("itensPedido");
			
			Double valorTotal = 0.0;
			for (ItemPedido itemPedido : intensPedido) {
				valorTotal += itemPedido.getPreco();
			}
			
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente);
			pedido.setData(new Date());
			pedido.setIntensPedido(intensPedido);
			pedido.setValorTotal(valorTotal);
			
			pedidoDao.inserir(pedido);
			
			return "pedidos/inseridoOk";
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@RequestMapping("relatorioPedidos")
	public String consultarPedidos(Model model) throws Exception{
		try {
			List<Pedido> pedidos = pedidoDao.consultarPedidos();
			model.addAttribute("pedidos", pedidos);
			return "pedidos/relatorio";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
