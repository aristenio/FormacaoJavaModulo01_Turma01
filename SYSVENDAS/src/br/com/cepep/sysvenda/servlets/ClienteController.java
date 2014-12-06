package br.com.cepep.sysvenda.servlets;

import java.sql.Connection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.sysvenda.conexao.ConnectionFactory;
import br.com.cepep.sysvenda.dao.ClienteDao;
import br.com.cepep.sysvenda.entidades.Cliente;

@Controller
public class ClienteController {
	
	@RequestMapping("/cadastrarCliente")
	public String cadastrarCliente(){
		return "clientes/cadastrar";
	}

	@RequestMapping("/inserirCliente")
	public String inserirCliente(@Valid Cliente cliente, BindingResult result){
		try {
			Connection connection = ConnectionFactory.getConnection();
			ClienteDao clienteDao = new ClienteDao(connection);
			
			if(result.hasFieldErrors())
				return "clientes/cadastrar";
			
			clienteDao.inserir(cliente);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "clientes/inseridoOk";
	}
	
	@RequestMapping("/listarClientes")
	public String listarClientes(Model model){
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			ClienteDao clienteDao = new ClienteDao(connection);
			List<Cliente> listarClientes = clienteDao.listarClientes();
			model.addAttribute("clientes", listarClientes);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "clientes/lista";
	}

}
