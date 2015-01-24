<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SYSVENDAS - Menu</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div id="content" class="container_16 clearfix">
		<div class="grid_16">
			<h2>Seja bem vindo ${usuario.nome}</h2>
		</div>
		<div class="grid_5">
			<div class="box">
				<h2>Clientes</h2>
				<div class="utils">
					<a href="#">Ver mais</a>
				</div>
				<table>
					<tbody>
						<tr>
							<td><a href="listarClientes">Listar clientes</a></td>
							<td>-</td>
						</tr>
						<tr>
							<td><a href="cadastrarCliente">Cadastrar clientes</a></td>
							<td>-</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="box">
				<h2>Produtos</h2>
				<div class="utils">
					<a href="#">Ver mais</a>
				</div>
				<table>
					<tbody>
						<tr>
							<td><a href="listarProdutos">Listar produtos</a></td>
							<td>-</td>
						</tr>
						<tr>
							<td><a href="cadastrarProdutos">Cadastrar produtos</a></td>
							<td>-</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="grid_5">
			<div class="box">
				<h2>Usuários</h2>
				<div class="utils">
					<a href="#">Ver mais</a>
				</div>
				<table>
					<tbody>
						<tr>
							<td><a href="listarUsuarios">Listar usuarios</a></td>
							<td>-</td>
						</tr>
						<tr>
							<td><a href="cadastrarUsuarios">Cadastrar usuario</a></td>
							<td>-</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="grid_5">
			<div class="box">
				<h2>Pedidos</h2>
				<div class="utils">
					<a href="#">Ver mais</a>
				</div>
				<table>
					<tbody>
						<tr>
							<td><a href="pedido">Efetuar pedido</a></td>
							<td>-</td>
						</tr>
						<tr>
							<td><a href="relatorioPedidos">Relatório de Pedidos</a></td>
							<td>-</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<c:import url="rodape.jsp" />
</html>