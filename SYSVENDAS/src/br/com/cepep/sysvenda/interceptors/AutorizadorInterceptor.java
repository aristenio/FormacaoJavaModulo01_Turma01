package br.com.cepep.sysvenda.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String uri = request.getRequestURI();
		
		if(uri.contains("index") || uri.contains("login") || uri.contains("logout") || uri.contains("resources"))
			return true;
		
		HttpSession sessao = request.getSession();
		
		if (sessao.getAttribute("usuario") != null){
			request.setAttribute("usuario", sessao.getAttribute("usuario"));
			return true;
		}
		
		response.sendRedirect("index");
		
		return false;
	}
	

}
