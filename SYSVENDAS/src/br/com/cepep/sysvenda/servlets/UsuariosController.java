package br.com.cepep.sysvenda.servlets;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.sysvenda.dao.UsuarioDAO;
import br.com.cepep.sysvenda.entidades.Usuario;

@Controller
public class UsuariosController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping("listarUsuarios")
	public String listarUsuarios(Model model){
		
		try {
			List<Usuario> listaUsuarios = usuarioDAO.listarUsuarios();
			model.addAttribute("usuarios", listaUsuarios);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "usuarios/lista";
	}

}
