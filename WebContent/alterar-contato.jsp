<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alterar contatos</title>
		<link href="css/jquery-ui.css" rel="stylesheet">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
	</head>
	<body>
		<c:import url="/cabecalho.jsp"/>
		<c:set var="contato" value="${contato}"></c:set>
		<form action="http://192.168.10.106:8080/Agenda/mvc?logica=AlterarContatoLogica">
			Nome: <input type="text" name="nome" value="${contato.nome}"/><br />
			E-mail: <input type="text" name="email" value="${contato.email}"/><br />
			Endereço: <input type="text" name="endereco" value="${contato.endereco}"/><br />
			Data Nascimento: <my:fieldDate id="dataNasc"/> <br />
			<script type="text/javascript">
				document.getElementById("dataNasc").value = "${contato.dataNasc}";
			</script>
			<input hidden="true" name="logica" value="AlterarContatoLogica" />
			<input name="id" hidden="true" value="${contato.id}" />
			<input type="submit" value="Editar" />
		</form>
		<c:import url="/rodape.jsp"/>
	</body>
</html>