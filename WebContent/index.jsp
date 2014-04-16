<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Picus ERP</title>
</head>
<body>
	Hello! This is a Picus ERP!

	<form action="hellowUser.jsp" method="post">
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="firstName" ></td>
			</tr>
			<tr>
				<td>Sobrenome:</td>
				<td><input type="text" name="secondName" ></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Enviar"></td>
			</tr>
		</table>

	</form>


</body>
</html>