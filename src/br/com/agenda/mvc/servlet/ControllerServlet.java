package br.com.agenda.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.mvc.logica.Logica;

@WebServlet ("/mvc")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Class<?> classe;
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String param = req.getParameter("logica");
		String className = "br.com.agenda.mvc.logica."+param;
		
		try {
			System.out.println(param);
			classe = Class.forName(className);
			Logica logica = (Logica) classe.newInstance();//apresenta erro aqui.
			String page = logica.executa(req, res);
			
			req.getRequestDispatcher(page).forward(req, res);
		}catch(Exception e) {
			throw new ServletException("A L�gica de neg�cios causou uma exce��o ", e);
		}
		
	}
}
