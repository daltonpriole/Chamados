<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="servlet.NovoUser" import="servlet.ControlAccess"%>
<%

%>
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
	  <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="http://localhost:8080/Chamados/Index.jsp">System Call</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li><a href="http://localhost:8080/Chamados/ListarChamados.jsp">Listar Chamado</a></li>
	        <li><a href="http://localhost:8080/Chamados/NovoChamado.jsp">Novo Chamado</a></li>
	        <%//if (ca.checkUser(request, response)) {%>
				<li><a href="http://localhost:8080/Chamados/NovoUser.jsp">Novo User
				<span class="sr-only">(current)</span></a></li>
				<li><a href="http://localhost:8080/Chamados/ListarUsers.jsp">Listar Users</a></li>
			<%//}%>
			<li><a href="http://localhost:8080/Chamados/Contato.jsp">Contato</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	      	<li><a href="http://localhost:8080/Chamados/Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	        <li><a href="http://localhost:8080/Chamados/Logoff.jsp"><span class="glyphicon glyphicon-log-off"></span> Logoff</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<br><br><br>
	<div class="container-fluid jumbotron">
		<hr/>
		<h1>Adicionar Novo Usuário</h1>
	</div>
	<div class="container-fluid" id='formulario'>
		<form class="form-horizontal" method='POST'>
			<div class="form-group">
				<label class="col-sm-2 control-label">Nome: </label>
				<div class="col-sm-10">
					<input type='text' class="form-control" name='titulo'>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">E-mail: </label>
				<div class="col-sm-10">
    				<input type="email" class="form-control" name="email">
    			</div>	
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Password:</label>
				<div class="col-sm-10">
					 <input class="form-control" type="password" name="password">
				</div>
			</div>
			<div class="form-group">
   				<div class="col-sm-offset-2 col-sm-10">
					 <button type="submit" class="btn btn-default">Enviar</button>
				</div>
			</div>
			</div>
		</form>
		
		<%
			NovoUser novo = new NovoUser();
			novo.add(request, response);
		%>

	</div>
</body>
</html>