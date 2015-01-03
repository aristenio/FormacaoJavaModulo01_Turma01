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
<title>Cadastro de produto</title>
</head>
<body>
	<form:errors path="produtos.nome" cssStyle="color:red"/>
	<form action="inserirProdutos" method="post">
		Nome:<input type="text" name="nome">
		<br>
		Preço: <input type="text" name="preco">
		<br>
		Preço Desconto: <input type="text" name="precoDesconto">
		<br>
		Desconto: <input type="text" name="desconto">
		<br>
		Descrição Pequena: <input type="text" name="descricaoPequena">
		<br>
		Descrição Grande: <input type="text" name="descricaoGrande">
		<br>
		Imagem: <input type="text" name="imagem">
		<br>
		Quantidade Estoque: <input type="text" name="quantidadeEstoque">
		<br>
		<input type="submit">
	</form>
</body>
<c:import url="../rodape.jsp"/>
</html>