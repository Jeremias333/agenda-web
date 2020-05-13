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
			$("#${id}").datepicker({changeMonth: true, changeYear: true, dateFormat: "yy-mm-dd"});
		</script>
	</body>
</html>