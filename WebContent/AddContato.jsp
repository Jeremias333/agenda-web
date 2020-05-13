<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastre o contato!</title>
		<link href="css/jquery-ui.css" rel="stylesheet">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
	</head>
	<body>
		<c:import url="/cabecalho.jsp"/>
		<form action="http://192.168.10.105:8080/Agenda/AddContato">
			Nome: <input type="text" name="nome" /><br />
			E-mail: <input type="text" name="email" /><br />
			Endereço: <input type="text" name="endereco" /><br />
			Data Nascimento: <my:fieldDate id="dataNasc"/><br />
			
			<input type="submit" value="Gravar" />
		</form>
		<c:import url="/rodape.jsp"/>
	</body>
</html>