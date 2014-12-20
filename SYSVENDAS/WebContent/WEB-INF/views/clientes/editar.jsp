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
<title>Edição de cliente</title>
</head>
<body>
	<form action="atualizarCliente" method="post">
		<input type="hidden" name="id" value="${cliente.id}">
		Nome:<input type="text" name="nome" value="${cliente.nome}">
		<br>
		Email: <input type="text" name="email" value="${cliente.email}">
		<br>
		Endereço: <input type="text" name="endereco" value="${cliente.endereco}">
		<br>
		Bairro: <input type="text" name="bairro" value="${cliente.bairro}">
		<br>
		Cidade: <input type="text" name="cidade" value="${cliente.cidade}">
		<br>
		Estado: <input type="text" name="estado" value="${cliente.estado}">
		<br>
		CEP: <input type="text" name="cep" value="${cliente.cep}">
		<br>
		Data nascimento: 
		<cepep:campoData id="data"/>
		<br>
		Ativo: <input type="checkbox" name="ativo" id="ativo" checked="${cliente.ativo eq true}">
		<input type="submit" name="Atualizar">
	</form>
</body>
<c:import url="../rodape.jsp"/>
</html>