<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="../cabecalho.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes</title>
<script type="text/javascript">
	function alterarStatus(id,status){
		$.get("atualizaStatusCliente?id="+id+"&ativo="+status, function(response){
			alert("Status alterado");
			if(status)
				$("#status"+id).html("Ativo");
			else
				$("#status"+id).html("Inativo");
		});
	}
</script>
</head>
<body>
<div id="content" class="container_16 clearfix">
	<div class="grid_16">
		<h2>Lista de Clientes</h2>
	</div>
	<div class="grid_16">
		<table>
			<th>ID</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Cidade</th>
			<th>Estado</th>
			<th>Ativo</th>
			<th>Ações</th>
			<th></th>
			<th></th>
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.email}</td>
					<td>${cliente.cidade}</td>
					<td>${cliente.estado}</td>
					<c:if test="${cliente.ativo eq true}">
						<td><span id="status${cliente.id}">Ativo</span></td>
						<td><a href="#" onclick="alterarStatus(${cliente.id},false)" >desativar</a></td>
					</c:if>
					<c:if test="${cliente.ativo eq false}">
						<td><span id="status${cliente.id}">Inativo</span></td>
						<td><a href="javascript:alterarStatus(${cliente.id},true);">ativar</a></td>
					</c:if>
					<td><a href="editarCliente?id=${cliente.id}" class="edit">editar</a></td>
					<td><a href="removerCliente?id=${cliente.id}" class="delete">remover</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="utils">
			<a href="cadastrarCliente">Cadastrar</a>
		</div>
	</div>
</div>
</body>
<c:import url="../rodape.jsp"/>
</html>