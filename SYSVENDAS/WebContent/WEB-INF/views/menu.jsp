<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SYSVENDAS - Menu</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>
	<h3>Seja bem vindo ${usuario.nome}</h3>

	<a href="listarClientes">Listar clientes</a>
	<br>
	<a href="cadastrarCliente">Cadastrar clientes</a>
	<br>
	<a href="listarProdutos">Listar produtos</a>
	<br>
	<a href="cadastrarProdutos">Cadastrar produtos</a>
	<br>
	<a href="listarUsuario">Listar usuarios</a>
	<br>
	<a href="cadastrarUsuarios">Cadastrar usuario</a>
</body>
<c:import url="rodape.jsp"/>
</html>