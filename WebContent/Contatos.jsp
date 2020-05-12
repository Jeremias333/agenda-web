<%@page import="br.com.agenda.models.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.agenda.db.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Todos os contatos</title>
	</head>
	<body>
		<%
			ContatoDao contatoDao = new ContatoDao();
			List<Contato> contatos = contatoDao.getList();//carrega toda lista de contatos do banco de dados.
			
			for(Contato contato : contatos){
		%>
			<ul>
				<li><b><%=contato.getNome()%></b>, <%=contato.getEmail()%>: <%=contato.getEndereco()%><br></li>
			</ul>
		<%
			}		
		%>
	</body>
</html>