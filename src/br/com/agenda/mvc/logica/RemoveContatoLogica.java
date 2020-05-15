package br.com.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.db.ContatoDao;
import br.com.agenda.models.Contato;

public class RemoveContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.remove(contato);
		
		System.out.println("Excluindo contato...");
		
		return "mvc?logica=ListaContatosLogica";
	}

}
