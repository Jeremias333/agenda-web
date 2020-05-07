package br.com.agenda.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(	
	name = "servlet1",
	urlPatterns = "/welcome",
	initParams = {
		@WebInitParam(name = "param1", value = "valor 1"),
		@WebInitParam(name = "param2", value = "valor 2")
	}//inicializando a página com variaveis pré-definidas.
)
//@WebServlet(name = "servelet1", urlPatterns = "/welcome")
public class WelcomePage extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private String parametro1;
	private String parametro2;
	
	//inicializando os dados passados e settando-os nas duas variaveis String.
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.parametro1 = config.getInitParameter("param1");
		this.parametro2 = config.getInitParameter("param2");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("daleeeeeeee");
		out.print("<br>");
		out.println("valor da variável 1 :"+ parametro1 +"<br>"
				+ "valor da variável 2 :"+ parametro2);
	}
}
