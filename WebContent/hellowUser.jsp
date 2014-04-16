<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Picus ERP</title>
</head>
<body>
	<%
		String firstName = request.getParameter("firstName");

		String secondName = request.getParameter("secondName");

		String fullName = firstName + " " + secondName;
	%>

	<h1>Picus ERP</h1>

	Ola, <%=fullName%>!

	<form action="index.jsp" method="post">
		<input type="submit" value="Voltar">

	</form>
</body>
</html>