package br.com.cepep.sysvenda.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesteSpringMVC {
	
	@RequestMapping("/testeSpringMVC")
	public String execute(){
		System.out.println("Spring MVC funcionando");
		return "ok";
	}

}
