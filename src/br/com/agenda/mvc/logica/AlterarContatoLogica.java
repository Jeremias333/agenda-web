package br.com.agenda.mvc.logica;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.db.ContatoDao;
import br.com.agenda.models.Contato;

public class AlterarContatoLogica implements Logica {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Contato contato = new Contato();
		ContatoDao contatoDao = new ContatoDao();
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		contato.setId(id);
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setDataNasc(Date.valueOf(req.getParameter("dataNasc")));
		contato.setEndereco(req.getParameter("endereco"));
		
		contatoDao.altera(contato);
		System.out.println("Alterando...");

		return "mvc?logica=ListaContatosLogica";
	}

}
