<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cepep"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="../cabecalho.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edição de produto</title>
</head>
<body>
	<form action="atualizarProduto" method="post">
		<input type="hidden" name="id" value="${produtos.id}">
		Nome:<input type="text" name="nome" value="${produtos.nome}">
		<br>
		Preço: <input type="text" name="preco" value="${produtos.preco}">
		<br>
		Preço Desconto: <input type="text" name="precoDesconto" value="${produtos.precoDesconto}">
		<br>
		Desconto: <input type="text" name="desconto" value="${produtos.desconto}">
		<br>
		Descrição Pequena: <input type="text" name="descricaoPequena" value="${produtos.descricaoPequena}">
		<br>
		Descrição Grande: <input type="text" name="descricaoGrande" value="${produtos.descricaoGrande}">
		<br>
		Imagem: <input type="text" name="imagem" value="${produtos.imagem}">
		<br>
		Quantidade Estoque: <input type="text" name="quantidadeEstoque" value="${produtos.quantidadeEstoque}">
		<br>
		
		<input type="submit" name="Atualizar">
	</form>
</body>
<c:import url="../rodape.jsp"/>
</html>