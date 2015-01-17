<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="../cabecalho.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedidos</title>
</head>
<body>
<h3>Cliente</h3>
<form action="consultarClientePedido" method="POST">
ID:
<br/>
<input type="text" id="idCliente" name="idCliente"/>
<br/>
<input type="submit" name="Consultar">
</form>

<table>
	<thead>ID</thead>
	<thead>Nome</thead>
	<thead>Email</thead>
	<tr>
		<td>${clientePedido.id}</td>
		<td>${clientePedido.nome}</td>
		<td>${clientePedido.email}</td>
	</tr>
</table>

<br>

<h3>Produtos</h3>
<form action="consultarProdutoPedido" method="POST">
ID:
<br/>
<input type="text" id="idProduto" name="idProduto"/>
<br/>
<input type="submit" name="Consultar">
</form>
<table>
	<thead>ID</thead>
	<thead>Produto</thead>
	<thead>Preço</thead>
	<thead></thead>
	<tr>
		<td>${produtoPedido.id}</td>
		<td>${produtoPedido.nome}</td>
		<td>${produtoPedido.preco}</td>
		<td><a href="adicionarProdutoPedido">Adicionar</a></td>
	</tr>
</table>

<h2>Itens do Pedido</h2>
<table>
	<thead>Produto</thead>
	<thead>Preço Unitário</thead>
	<thead>Quantidade</thead>
	<thead>Total</thead>
	<c:forEach items="${itensPedido}" var="itemPedido">
		<tr>
			<td>${itemPedido.produto.nome}</td>
			<td>${itemPedido.produto.preco}</td>
			<td>${itemPedido.quantidade}</td>
			<td>${itemPedido.preco}</td>
		</tr>
	</c:forEach>
</table>


</body>



<c:import url="../rodape.jsp"/>
</html>