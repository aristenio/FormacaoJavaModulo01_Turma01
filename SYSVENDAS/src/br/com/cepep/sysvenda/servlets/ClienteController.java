package br.com.cepep.sysvenda.servlets;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.sysvenda.dao.ClienteDao;
import br.com.cepep.sysvenda.entidades.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteDao clienteDao;
	
	@RequestMapping("cadastrarCliente")
	public String cadastrarCliente(){
		return "clientes/cadastrar";
	}
	
	@RequestMapping("editarCliente")
	public String editarCliente(Long id, Model model){
		
		try {
			Cliente cliente = clienteDao.consultarCliente(id);
			model.addAttribute("cliente", cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "clientes/editar";
	}

	@RequestMapping("inserirCliente")
	public String inserirCliente(@Validated Cliente cliente, BindingResult result){

		if(result.hasFieldErrors())
			return "clientes/cadastrar";
		
		try {
			clienteDao.inserir(cliente);			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "clientes/inseridoOk";
	}
	
	@RequestMapping("atualizarCliente")
	public String atualizarCliente(Cliente cliente){
		try {
			clienteDao.atualizarCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "forward:listarClientes";
	}
	
	@RequestMapping("listarClientes")
	public String listarClientes(Model model, HttpSession sessao){
		
		try {
			List<Cliente> listarClientes = clienteDao.listarClientes();
			model.addAttribute("clientes", listarClientes);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "clientes/lista";
	}
	
	@RequestMapping("removerCliente")
	public String removerCliente(Cliente cliente){
		
		try {
			clienteDao.removerCliente(cliente.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "forward:listarClientes";
	}
	
	@RequestMapping("atualizaStatusCliente")
	public void atualizaStatusCliente(Cliente cliente, HttpServletResponse response){
		try {
			cliente = clienteDao.consultarCliente(cliente.getId());
			clienteDao.atualizaStatusCliente(cliente.getId(), !cliente.getAtivo());
			response.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}
	}

}
