<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes</title>
</head>
<body>
	<table>
		<th>ID</th>
		<th>Nome</th>
		<th>Email</th>
		<th>Endereco</th>
		<th>Bairro</th>
		<th>Cidade</th>
		<th>Estado</th>
		<th>CEP</th>
		<c:forEach items="${clientes}" var="cliente">
			<tr>
				<td>${cliente.id}</td>
				<td>${cliente.nome}</td>
				<td>${cliente.email}</td>
				<td>${cliente.endereco}</td>
				<td>${cliente.bairro}</td>
				<td>${cliente.cidade}</td>
				<td>${cliente.estado}</td>
				<td>${cliente.cep}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>