<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="../cabecalho.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Produtos</title>

</head>
<body>
	<table>
		<th>ID</th>
		<th>Nome</th>
		<th>Login</th>
		<th></th>
		<th></th>
		<th></th>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.login}</td>
				
				<td><a href="editarProdutos?id=${usuario.id}">editar</a></td>
				<td><a href="removerProdutos?id=${usuario.id}">remover</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="cadastrarUsuarios">Cadastrar</a>
</body>
<c:import url="../rodape.jsp"/>
</html>