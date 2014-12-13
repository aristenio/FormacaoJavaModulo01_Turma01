package br.com.cepep.sysvenda.servlets;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.sysvenda.conexao.ConnectionFactory;
import br.com.cepep.sysvenda.dao.UsuarioDAO;
import br.com.cepep.sysvenda.entidades.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("login")
	public String login(Usuario usuario, HttpSession sessao){
		
		try {
			UsuarioDAO usuarioDao = new UsuarioDAO(ConnectionFactory.getConnection());
			
			if(usuarioDao.existeUsuario(usuario.getId())){
				sessao.setAttribute("usuario", usuario);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "menu";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession sessao){
		sessao.invalidate();
		
		return "redirect:index";
	}

}
