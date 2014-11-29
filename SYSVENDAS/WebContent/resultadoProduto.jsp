<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="dao" class="br.com.cepep.sysvenda.dao.ProdutoDao"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado da busca</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<table border="1">
		<tr>
			<td>Nome</td>
			<td>Descricao</td>
			<td>Preço</td>
			<td>Data cadastro</td>
		</tr>
		<c:forEach var="produto" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
				<td>${produto.nome}</td>
				<td>
					<c:if test="${not empty produto.descricaoGrande}">
						${produto.descricaoGrande}
					</c:if>
				</td>
				<td>${produto.preco}</td>
				<td>
					<fmt:formatDate value="${produto.dataCadastro}" pattern="dd/MM/yyyy"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp"/>
</body>
</html>