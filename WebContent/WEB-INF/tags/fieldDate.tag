<%@ attribute name="id"  required="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="css/jquery-ui.css" rel="stylesheet">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
	</head>
	<body>
		<input type="text" id="${id}" name="${id}"/>
		<script type="text/javascript">
			var atualyData = new Date().getFullYear();
			$("#${id}").datepicker({changeMonth: true, changeYear: true, dateFormat: "yy-mm-dd", yearRange:'1940:'+atualyData});
		</script>
	</body>
</html>