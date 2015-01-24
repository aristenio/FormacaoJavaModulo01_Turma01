<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="../cabecalho.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedidos</title>
</head>
<body>
	<div id="content" class="container_16 clearfix">
		<div class="grid_16">
			<h2>Efetuar Pedido</h2>
		</div>
		<form action="consultarClientePedido" method="POST">
			<div class="grid_4">
				<p>
					<label>Cliente<small>id do cliente</small></label> 
					<input	type="text" id="idCliente" name="idCliente" />
				</p>
			</div>
			<div class="grid_2">
				<p>
					<label>&nbsp;</label> 
					<input type="submit" value="Buscar" />
				</p>
			</div>
		</form>
		<div class="grid_16">
			<table>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<tr>
					<td>${clientePedido.id}</td>
					<td>${clientePedido.nome}</td>
					<td>${clientePedido.email}</td>
				</tr>
			</table>
		</div>

		<form action="consultarProdutoPedido" method="POST">
		<div class="grid_4">
				<p>
					<label>Produto<small>id do produto</small></label> 
					<input type="text" id="idProduto" name="idProduto" />
				</p>
			</div>
			<div class="grid_2">
				<p>
					<label>&nbsp;</label> 
					<input type="submit" value="Buscar" />
				</p>
			</div>
		</form>
		<div class="grid_16">
			<table>
				<th>ID</th>
				<th>Produto</th>
				<th>Preço</th>
				<th></th>
				<tr>
					<td>${produtoPedido.id}</td>
					<td>${produtoPedido.nome}</td>
					<td>${produtoPedido.preco}</td>
					<td><a href="adicionarProdutoPedido" class="add">Adicionar</a></td>
				</tr>
			</table>
		</div>
		<div class="grid_16">
			<h2>Itens do Pedido</h2>
			<table>
				<th>Produto</th>
				<th>Preço Unitário</th>
				<th>Quantidade</th>
				<th>Total</th>
				<c:forEach items="${itensPedido}" var="itemPedido">
					<tr>
						<td>${itemPedido.produto.nome}</td>
						<td>${itemPedido.produto.preco}</td>
						<td>${itemPedido.quantidade}</td>
						<td>${itemPedido.preco}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
</body>
<c:import url="../rodape.jsp" />
</html>