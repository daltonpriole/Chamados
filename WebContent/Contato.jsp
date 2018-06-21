<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<li><a href="http://localhost:8080/Chamados/NovoUser.jsp">Novo User</a></li>
			<li><a href="http://localhost:8080/Chamados/ListarUsers.jsp">Listar Users</a></li>
			<li><a href="http://localhost:8080/Chamados/Contato.jsp">Contato
			<span class="sr-only">(current)</span></a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	      	<li><a href="http://localhost:8080/Chamados/Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	        <li><a href="http://localhost:8080/Chamados/Logoff.jsp"><span class="glyphicon glyphicon-log-off"></span> Logoff</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<br><br><br>
    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">

          <!-- Title -->
          <!-- Preview Image -->
          <img class="img-fluid rounded" src="imagens/logo hece.jpg" alt="">

        </div>

        <div class="col-lg-offset-1 col-lg-5 col-md-offset-1 col-md-5 col-sm-12 col-xs-12">
                  <div class="contact-form">
                      <h3 class="contact-info-title">Contato</h3>
                      <div class="row">
                          <form>
                              <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                  <div class="form-group">
                                      <label class="control-label sr-only " for="Name"></label>
                                      <input id="name" type="text" placeholder="Name" class="form-control" required>
                                  </div>
                              </div>
                              <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                  <div class="form-group">
                                      <label class="control-label sr-only " for="email"></label>
                                      <input id="email" type="text" placeholder="Email" class="form-control" required>
                                  </div>
                              </div>
                              <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                  <div class="form-group">
                                      <label class="control-label sr-only " for="Phone"></label>
                                      <input id="phone" type="text" placeholder="Phone" class="form-control" required>
                                  </div>
                              </div>
                              <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                  <div class="form-group">
                                      <label class="control-label required sr-only" for="select"></label>
                                      <select class="form-control">
                                          <option value="">Qual o tipo do seu problema?</option>
                                          <option value="">Eletrico</option>
                                          <option value="">Eletronico</option>
                                          <option value="">Mecanico</option>
                                          <option value="">Pneumatico</option>
                                          <option value="">Operacional</option>
                                          <option value="">Software</option>
                                      </select>
                                  </div>
                              </div>
                              <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mb20">
                                  <div class="form-group">
                                      <label class="control-label sr-only" for="textarea"></label>
                                      <textarea class="form-control pdt20" id="textarea" name="textarea" rows="4" placeholder="Message"></textarea>
                                  </div>
                              </div>
                              <div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
                                  <button class="btn btn-primary btn-lg ">Enviar</button>
                              </div>
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  <div class="space-medium">
      <div class="container">
          <div class="row">
              <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mb60">
                  <hr>
              </div>
          </div>
          <div class="row">
              <div class="col-lg-5 col-md-5 col-sm-6 col-xs-12">
                  <div id="contact-map"></div>
              </div>
              <div class="col-lg-offset-1 col-lg-5 col-md-offset-1 col-md-5 col-sm-6 col-xs-12">
                  <div class="">
                      <h3 class="title-bold">Informações</h3>
                  </div>
                  <div class="contact-section">
                      <div class="contact-icon"><i class="fa fa-map-marker"></i></div>
                      <div class="contact-info">
                          <p>Rua João Abdelnur, 99 - São Carlos - SP, Brasil</p>
                      </div>
                  </div>
                   <div class="contact-section">
                      <div class="contact-icon"><i class="fa fa-phone"></i></div>
                      <div class="contact-info">
                          <p>+55 (16)33632600 </p>
                      </div>
                  </div>
                   <div class="contact-section">
                      <div class="contact-icon"><i class="fa fa-envelope"></i></div>
                      <div class="contact-info">
                          <p>hece@hece.com.br</p>
                      </div>
                  </div>
              </div>
          </div>
          <div class="row">
                  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12  text-center">
            Criado por <a href="http://hece.com.br" target="_blank">Hece Maquinas</a>
            </div></div>
      </div>
  </div>
      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-4 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; ForumSite v1.00_2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>