<%@page import="java.util.*,
				java.sql.*,
				br.com.cepep.sysvenda.dao.ProdutoDao,
				br.com.cepep.sysvenda.entidades.Produto
				"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>Nome</td>
		<td>Descricao</td>
		<td>Preço</td>
	</tr>
	<%
		ProdutoDao produtoDao = new ProdutoDao();
		try {
			List<Produto> listaProdutos = produtoDao.getLista();

			for (Produto produto : listaProdutos) {
				%>
				<tr>
					<td><%= produto.getNome()%></td>
					<td><%= produto.getDescricaoGrande()%></td>
					<td><%= produto.getPreco()%></td>
				</tr>
				<%
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	%>
</table>
</body>
</html>