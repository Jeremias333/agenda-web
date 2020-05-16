<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Contatos</title>
		<style type="text/css">
			table tr{background: Beige;}
			table tr:nth-child(2n+1){background: LightCyan;}
		</style>
	</head>
	<body>
		<header><c:import url="../../cabecalho.jsp"/></header>
		<br>
		<table>
			<tr style="background:black;" align="center">
				<td style="color:white;" width="20%">Nome</td>
				<td style="color:white;" width="20%">Email</td>
				<td style="color:white;" width="20%">Endereço</td>
				<td style="color:white;" width="20%">Data de Nascimento</td>
				<td>Remoção</td>
				<td>Editar</td>
			</tr>
			<c:forEach var="contato" items="${contatos}">
				<tr align="center">
					<td>${contato.nome}</td>
					<td>
						<c:if test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:if>
						<c:if test="${empty contato.email}">
							<label>Não foi informado!</label>
						</c:if>
					</td>
					<td>${contato.endereco}</td>
					<td>
						<fmt:formatDate value="${contato.dataNasc}" pattern="dd/MM/yyyy"/>
					</td>
					
					<td>
						<a style="color:red;" href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a>
					</td>
					<td>
						<a style="color:green;" href="mvc?logica=ListarLogica&id=${contato.id}">Editar</a>
					</td>
				</tr>
			</c:forEach>
		</table><br>
		<footer><c:import url="../../rodape.jsp"></c:import></footer>
	</body>
</html>