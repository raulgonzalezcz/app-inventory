<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<div> 
	<h2>Usuarios</h2>
	<hr> 
	<p><a href="<s:url action="showInicio" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
	<center>
		<p><a href="<s:url action="showRegisterForm" namespace="/actions/socios" />" class="btn btn-info" role="button">Registrar usuario <span class="glyphicon glyphicon-user"></span></a> </p>
	</center>
	<hr>

	<div class="panel panel-primary">
  		<div class="panel-heading text-center"> 
  			<strong class="text-center"><h4>Usuarios</h4></strong>
  		</div>
  		<div class="panel-body">
			<table class="table table-hover table-responsive">
			    <thead>
			    	<tr>
			        	<th>#</th>
				        <th>Nombre</th>
				        <th>Apellidos</th>
				        <th>Correo</th>
				        <th>Admin</th>
				        <th>Activo</th>
				        <th>Fecha alta</th>
			      	</tr>
			    </thead>
			    <tbody>
			    	<c:forEach items="${usuarios}" var="usuario"> 					 
						<tr>
							<td>${usuario.id}</td>  
							<td>${usuario.nombre}</td> 
							<td>${usuario.apellidos}</td> 
							<td>${usuario.correo}</td>
							<td>${usuario.admin}</td>
							<td>${usuario.activo}</td> 
							<td>${usuario.fecha}</td> 
						</tr> 				
					</c:forEach>
			    </tbody>
			</table>	
		</div>
	</div>
</div><!-- /card-container -->
