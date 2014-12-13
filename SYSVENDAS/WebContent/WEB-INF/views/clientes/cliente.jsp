<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<td>${cliente.id}</td>
<td>${cliente.nome}</td>
<td>${cliente.email}</td>
<td>${cliente.endereco}</td>
<td>${cliente.bairro}</td>
<td>${cliente.cidade}</td>
<td>${cliente.estado}</td>
<td>${cliente.cep}</td>
<c:if test="${cliente.ativo eq true}">
	<td><span id="status${cliente.id}">Ativo</span></td>
	<td><a href="#" onclick="alterarStatus(${cliente.id},false)">desativar</a></td>
</c:if>
<c:if test="${cliente.ativo eq false}">
	<td><span id="status${cliente.id}">Inativo</span></td>
	<td><a href="javascript:alterarStatus(${cliente.id},true);">ativar</a></td>
</c:if>
<td><a href="removerCliente?id=${cliente.id}">remover</a></td>
