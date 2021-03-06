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
		<h2>Lista de Produtos</h2>
	</div>
	<div class="grid_16">
		<table>
			<th>ID</th>
			<th>Nome</th>
			<th>Pre�o</th>
			<th>Pre�o com Desc.</th>
			<th>Desconto</th>
			<th>Descri��o Pequena</th>
			<th>Descri��o Grande</th>
			<th>Imagem</th>
			<th>Quantidade no Estoque</th>
			<th>A��es</th>
			<th></th>
			<th></th>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td>${produto.id}</td>
					<td>${produto.nome}</td>
					<td>${produto.preco}</td>
					<td>${produto.precoDesconto}</td>
					<td>${produto.desconto}</td>
					<td>${produto.descricaoPequena}</td>
					<td>${produto.descricaoGrande}</td>
					<td>${produto.imagem}</td>
					<td>${produto.quantidadeEstoque}</td>
					
					<td><a href="editarProdutos?id=${produto.id}" class="edit">editar</a></td>
					<td><a href="removerProdutos?id=${produto.id}" class="delete">remover</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="utils">
			<a href="cadastrarProdutos">Cadastrar Novo Produto</a>
		</div>
	</div>
</div>

</body>
<c:import url="../rodape.jsp"/>
</html>