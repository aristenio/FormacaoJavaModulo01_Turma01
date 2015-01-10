<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cepep"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="../cabecalho.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de usuarios</title>
</head>
<body>
	<form:errors path="usuario.nome" cssStyle="color:red"/>
	<form action="inserirUsuario" method="post">
		Nome:<input type="text" name="nome">
		<br>
		Login: <input type="text" name="login">
		<br>
		Senha: <input type="text" name="senha">
		<br>
		<input type="submit">
	</form>
</body>
<c:import url="../rodape.jsp"/>
</html>