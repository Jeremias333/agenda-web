<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<div>
			<c:url value="/img/cabecalho.jpg" var="imagem"/>
			<img alt="" src="${imagem}" width="100%" height="20%">
		</div>
		<hr>
	</body>
</html>