<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Bem Vindo</title>
	</head>
	<body>
	<%-- coment�rio em JSP aqui: nossa primeira p�gina JSP --%>
	<%
		String mensagem = "Bem vindo ao sistema de Agenda!";
	%>
	<% out.println(mensagem); %>
	<br />
	<%
		String desenvolvido = "Desenvolvido por (Jeremias)";
	%>
	<%= desenvolvido %><%--Print de vari�vel--%>
	<br />
	<%
		System.out.println("Tudo foi executado!");
	%>
	</body>
</html>