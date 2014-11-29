<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cepep"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="cabecalho.jsp"/>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de produtos</title>
</head>
<body>
	<form action="produtos" method="post">
		Nome:<input type="text" name="nome">
		<br>
		Descrição: <input type="text" name="descricao">
		<br>
		Descrição reduzida: <input type="text" name="descricaoReduzida">
		<br>
		Preço: <input type="text" name="preco">
		<br>
		Preço com desconto: <input type="text" name="precoDesconto">
		<br>
		Desconto: <input type="text" name="desconto">
		<br>
		Imagem: <input type="text" name="imagem">
		<br>
		Data cadastro: 
		<cepep:campoData id="data"/>
		<br>
		<input type="submit">
	</form>

</body>
<c:import url="rodape.jsp"/>
</html>