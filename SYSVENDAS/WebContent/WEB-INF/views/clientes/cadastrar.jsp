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
<title>Cadastro de cliente</title>
</head>
<body>
	<div id="content" class="container_16 clearfix">
		<div class="grid_16">
			<h2>Cadastrar cliente</h2>
			<p class="error"><form:errors path="cliente.nome" cssStyle="color:red"/></p>
		</div>
		<form action="inserirCliente" method="post">
			<div class="grid_10">
				<p>
					<label for="title">Nome <small>Deve conter caracteres alfanuméricos.</small></label>
					<input type="text" name="nome">
				</p>
			</div>
			<div class="grid_5">
				<p>
					<label for="title">Email <small>Deve conter caracteres alfanuméricos.</small></label>
					<input type="text" name="email">
				</p>
			</div>
			<div class="grid_14">
				<p>
					<label for="title">Endereço<small>Deve conter caracteres alfanuméricos.</small></label>
					<input type="text" name="endereco">
				</p>
			</div>
			<div class="grid_5">
				<p>
					<label for="title">Bairro</label>
					<input type="text" name="bairro">
				</p>
			</div>
			<div class="grid_5">
				<p>
					<label for="title">Cidade</label>
					<input type="text" name="cidade">
				</p>
			</div>
			<div class="grid_2">
				<p>
					<label for="title">Estado</label>
					<input type="text" name="estado">
				</p>
			</div>
			<div class="grid_3">
				<p>
					<label for="title">CEP</label>
					<input type="text" name="cep">
				</p>
			</div>
			<div class="grid_3">
				<p>
					<label for="title">Dt. de nasc.</label>
					<cepep:campoData id="data"/>
				</p>
			</div>
			<div class="grid_2">
				<p>
					<label for="title">Ativo</label>
					<input type="checkbox" name="ativo">
				</p>
			</div>
			<div class="grid_16">
				<p class="submit">
					<input type="reset" value="Resetar" />
					<input type="submit" value="Salvar" />
				</p>
			</div>
		</form>
	</div>
</body>
<c:import url="../rodape.jsp"/>
</html>