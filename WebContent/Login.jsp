<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="javax.servlet.http.HttpSession" 
	import="servlet.ControlAccess"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Projeto ADS HelpDesk</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header"></div>
	  </div>
	</nav>
	<div class="container-fluid jumbotron" id='cabecalho'>
		<h1>Entrar no Sistema</h1>
		<hr/>
		<h3>Olá! Vamos ao Atendimento</h3>
	</div>
	<div class="container-fluid" id='corpo'>
		<form class="form-inline" id='formLogin' method='POST'>
			<div class="form-group">
				<label>Usuario:</labeL>
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
					<input class="form-control"  type='text' name='user'>
				</div>
			</div>
			<div class="form-group">
				<label>Senha:</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
					<input class="form-control" type='password' name='password'> 
				</div> 
			</div>
			<div class="form-group">
   				 <div class="col-sm-offset-2 col-sm-10">
					<Button type='submit' class="btn btn-default" value="logar">Entrar</Button>
				</div>
			</div>
		</form>
	<%
		ControlAccess ca = new ControlAccess();
		ca.comunication(request, response);
	%>
	</div>
</body>
</html>