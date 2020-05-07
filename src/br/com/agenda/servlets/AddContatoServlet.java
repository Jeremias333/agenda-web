package br.com.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.agenda.db.ContatoDao;
import br.com.agenda.models.Contato;

@WebServlet("/addContato")
public class AddContatoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Date dataNasc;
	private String email;
	private String endereco;
	private String nome;
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		
		nome = req.getParameter("nome");
		endereco = req.getParameter("endereco");
		email = req.getParameter("email");
		String dataText = req.getParameter("dataNasc");
		try {
			Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataText);
			dataNasc = date;
		}catch(Exception e) {
			 out.println("Ocorreu um erro na renderiza��o da p�gina: "+e);
		}
		
		//Populating
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNasc(dataNasc);
		
		//Saving
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.add(contato);
		
		// imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() +
		" adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
	}
}
