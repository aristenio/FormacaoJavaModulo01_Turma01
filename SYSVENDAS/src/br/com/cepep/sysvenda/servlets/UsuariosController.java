package br.com.cepep.sysvenda.servlets;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.sysvenda.dao.UsuarioDAO;
import br.com.cepep.sysvenda.entidades.Usuario;
import br.com.cepep.sysvenda.entidades.Usuario;
import br.com.cepep.sysvenda.entidades.Usuario;
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
	
	@RequestMapping("cadastrarUsuarios")
	public String cadastrarUsuarios(){
		return "usuarios/cadastrar";
	}
	
	@RequestMapping("inserirUsuario")
	public String inserirUsuario(@Validated Usuario usuario){
		
		try {
			usuarioDAO.inserir(usuario);			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "usuarios/inseridoOk";
	}
	
	@RequestMapping("removerUsuario")
	public String removerUsuario(Long id){
		try {
			usuarioDAO.remover(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "forward:listarUsuarios";
	}
	
	@RequestMapping("editarUsuario")
	public String editarUsuario(Long id, Model model){
		
		try {
			Usuario usuario = usuarioDAO.consultarUsuario(id);
			model.addAttribute("usuario", usuario);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "usuarios/editar";
	}
	
	@RequestMapping("atualizarUsuario")
	public String atualizarUsuario(Usuario usuario){
		try {
			usuarioDAO.atualizar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "forward:listarUsuarios";
	}



}
