package br.com.cepep.sysvenda.servlets;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.sysvenda.dao.UsuarioDAO;
import br.com.cepep.sysvenda.entidades.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("login")
	public String login(Usuario usuario, Model model, HttpSession sessao) throws Exception{
		
		try {
			Usuario usuarioLogado = usuarioDAO.existeUsuario(usuario.getLogin(), usuario.getSenha());
			if(usuarioLogado != null ){
				sessao.setAttribute("usuario", usuario);
				model.addAttribute("usuario", usuario);
			}else
				return "index";
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return "menu";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession sessao){
		sessao.invalidate();
		
		return "redirect:index";
	}
	
	@RequestMapping("menu")
	public String menu(){
		return "menu";
	}

}
