<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
<title>Cadastro seguro domiciliar</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
		<form action="/cep" method="post">
			<div class="form-group">
				<label>Cep:</label>
				<input type="text" value="" name="cep" class="form-control">
				<button type="submit" value="${endereco.cep}" class="btn btn-gray">Buscar</button>
			</div>
		</form>

		<form action="/seguro/domicilio/incluir" method="post">
			<div class="form-group">
				<label>Cep:</label>
				<input type="text" value="${endereco.cep}" name="cep" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Logradouro:</label>
				<input type="text" value="${endereco.logradouro}" name="logradouro" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Complemento:</label>
				<input type="text" value="${endereco.complemento}" name="complemento" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Bairro:</label>
				<input type="text" value="${endereco.bairro}" name="bairro" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Localidade:</label>
				<input type="text" value="${endereco.localidade}" name="localidade" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Uf:</label>
				<input type="text" value="${endereco.uf}" name="uf" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Valor do contrato:</label>
				<input type="number" name="valorContrato" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Valor indenização:</label>
				<input type="number" name="valorIndenizacao" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Data de assinatura do contrato:</label>
				<input type="datetime-local" name="assinatura" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Data final do contrato:</label>
				<input type="datetime-local" name="fim" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>CPF proprietario:</label>
				<input type="text" name="cpfProprietario" class="form-control">
			</div>
			<hr>
			<div class="form-group">
				<label>Metragem imovel:</label>
				<input type="number" name="metragemImovel" class="form-control">
			</div>
			<hr>
			<button type="submit" class="btn btn-gray">Cadastrar</button>
		</form>
	</div>
</body>
</html>