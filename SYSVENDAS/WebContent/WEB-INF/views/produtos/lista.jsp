<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos</title>
</head>
<body>
	<table>
		<th>ID</th>
		<th>Nome</th>
		<th>Preço</th>
		<th>Desconto</th>
		<th>Descrição</th>
		<th>Quantidade</th>
		<th>Data Cadastro</th>
		<c:forEach items="${produtos}" var="produto">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.nome}</td>
				<td>${produto.preco}</td>
				<td>${produto.desconto}</td>
				<td>${produto.descricao}</td>
				<td>${produto.quantidade}</td>
				<td>${produto.dataCadastro}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>