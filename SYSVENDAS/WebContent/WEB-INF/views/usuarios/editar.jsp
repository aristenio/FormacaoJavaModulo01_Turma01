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
<title>Edição de usuario</title>
</head>
<body>
	<form action="atualizarUsuario" method="post">
		<input type="hidden" name="id" value="${usuario.id}">
		Nome:<input type="text" name="nome" value="${usuario.nome}">
		<br>
		Login: <input type="text" name="login" value="${usuario.login}">
		<br>
		Senha: <input type="text" name="senha" value="${usuario.senha}">
		<br>
		<input type="submit" name="Atualizar">
	</form>
</body>
<c:import url="../rodape.jsp"/>
</html>