<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.agenda.db.ContatoDao"%>
<%@page import="br.com.agenda.models.Contato"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<%
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			ContatoDao contatoDao = new ContatoDao();
			List<Contato> contatos = contatoDao.getList();
			%>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>	
			<%
			for (Contato contato : contatos ) {
			%>
				
				<tr>
					<td><%=contato.getNome() %></td>
					<td><%=contato.getEmail() %></td>
					<td><%=contato.getEndereco() %></td>
					<td><%=formatter.format(contato.getDataNasc()) %></td>
				</tr>
			<%
			}
			%>
		</table>
	</body>
</html>