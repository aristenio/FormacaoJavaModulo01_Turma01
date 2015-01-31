<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="../cabecalho.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatório de pedidos</title>
</head>
<body>
<div id="content" class="container_16 clearfix">
	<div class="grid_16">
		<h2>Relatório de pedidos</h2>
	</div>
	<div class="grid_16">
		<table>
			<th>ID</th>
			<th>Cliente</th>
			<th>Data</th>
			<th>Valor</th>
			<c:forEach items="${pedidos}" var="pedido">
				<tr>
					<td>${pedido.id}</td>
					<td>${pedido.cliente.nome}</td>
					<td>
						<fmt:formatDate pattern="dd-MM-yyyy" value="${pedido.data}"/>
					</td>
					<td>${pedido.valorTotal}</td>
				</tr>
				<tr></tr>
				<tr>Produto</tr>
				<tr>Quantidade</tr>
				<tr>Valor Unitário</tr>
				<c:forEach items="${pedido.itensPedido}" var="itemPedido">
					<tr>
						<td></td>
						<td>${itemPedido.produto.nome}</td>
						<td>${itemPedido.quantidade}</td>
						<td>${itemPedido.produto.preco}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>