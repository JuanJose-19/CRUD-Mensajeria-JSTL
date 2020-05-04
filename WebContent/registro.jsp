<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">		
	<title>Registro</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" href="css/cover.css" />
</head>


<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">JSTL</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link " href="registro.jsp">Registrar</a>
        <a class="nav-link" href="editar.jsp">Editar</a>
        <a class="nav-link" href="eliminar.jsp">Eliminar</a>
        <a class="nav-link" href="listar.jsp">Listar</a>
        <a class="nav-link active" href="registro.jsp">Registrar</a>
      </nav>
    </div>
  </header>

	<main role="main" class="inner cover">
		
		<form action="MensajeServlet" method="post">
		
		    <div class="form-group"> 
		        <label for="Nombre" class="control-label">Nombre</label>
		        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
		    </div>     
		    
		    <div class="form-group"> 
		        <label for="email" class="control-label">Email</label>
		        <input type="email" class="form-control" id="email" name="email" placeholder="juanjose@gmail.com">
		    </div> 
		
		    <div class="form-group"> 
		        <label for="sitioweb" class="control-label">Sitio Web</label>
		        <input type="text" class="form-control" id="sitioweb" name="siotioweb" placeholder="Sitio Web">
		    </div>                    		                            
		    <div class="form-group"> 
		        <label for="mensaje" class="control-label">Mensaje</label>
		        <input type="text" class="form-control" id="mensaje" name="mensaje" placeholder="Mensaje">
		    </div>

				<jsp:useBean id="m" class="Negocio.Mensajeria" />
				<div class="form-group">
					<label for="formGroupExampleInput2">usuarios: </label> <br> <select
						name="usuarios">
						<c:forEach var="u" items="${m.getUsuario()}">
							<option value="<c:out value="${u.usuario}"/>"><c:out
									value="${u.usuario}" /></option>
						</c:forEach>
					</select>
				</div>


				<div class="form-group"> 
		        <button type="submit" class="btn btn-primary">Registrarse</button>
		    </div>       
		</form>
	</main>
	

	<footer class="mastfoot mt-auto text-center">
	    <div class="inner">
	      <p>Guia De Hibernate - <a href="#"> Programación Web  </a>Juan José Contreras<a href="#">  1151148</a>.</p>
	    </div>
  </footer>

</div>

 
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>