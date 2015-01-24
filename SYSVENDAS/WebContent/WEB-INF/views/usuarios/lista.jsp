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
<div id="content" class="container_16 clearfix">
	<div class="grid_16">
		<h2>Lista de Usuários</h2>
	</div>
	<div class="grid_16">
		<table>
			<th>ID</th>
			<th>Nome</th>
			<th>Login</th>
			<th>Ações</th>
			<th></th>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.login}</td>
					<td><a href="editarUsuario?id=${usuario.id}" class="edit">editar</a></td>
					<td><a href="removerUsuario?id=${usuario.id}" class="delete">remover</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="utils">
			<a href="cadastrarUsuarios">Cadastrar</a>
		</div>
	</div>
</div>

</body>
<c:import url="../rodape.jsp"/>
</html>