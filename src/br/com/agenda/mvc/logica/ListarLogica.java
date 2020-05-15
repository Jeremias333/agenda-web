package br.com.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.db.ContatoDao;
import br.com.agenda.models.Contato;

public class ListarLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		Contato contato = new ContatoDao().getContatoById(id);
		req.setAttribute("contato", contato);
		
		return "alterar-contato.jsp";
	}

}
