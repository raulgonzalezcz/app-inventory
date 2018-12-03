<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
	<script src="js/test.js"></script>
	<script src="js/sweetalert2.all.min.js"></script>
</head>

<%-- Manejo de mensajes --%>
<s:if test="hasActionMessages()">
	<div class="alert alert-success fade in">
		<a href="#" class="close" data-dismiss="alert">×</a>  
      	<strong><s:actionmessage/></strong>
   	</div>
</s:if>
<%-- Manejo de mensajes de error --%>
<s:if test="hasActionErrors()">
	<div class="alert alert-warning fade in">
		<a href="#" class="close" data-dismiss="alert">×</a> 
      	<strong><s:actionerror/></strong>
   	</div>
</s:if>
<h2>Bienvenido, <span class="text-primary">${sessionScope.nombreCompleto}</span></h2>
<hr>
<h4 class="text text-info"><b>Info usuario:</b></h4> 
<div class="row" style="margin: 10px">
    <div class="col-md-1"></div>
    <div class="col-md-10"> 
    	<div class="table-responsive">
			<table class="table table-hover">
			    <thead>
			    	<tr>
				        <th>Nombre</th>
				        <th>Apellidos</th>
				        <th>Correo</th>
				        <th>Admin</th>
				        <th>Activo</th>
				        <th>Fecha creación</th>
			      	</tr>
			    </thead>
			    <tbody>				 
					<tr>  
						<td>${sessionScope.nombre}</td> 
						<td>${sessionScope.apellidos}</td> 
						<td>${sessionScope.correo}</td> 
						<td>${sessionScope.isAdmin}</td> 
						<td>${sessionScope.isActivo}</td> 
						<td>${sessionScope.fecha}</td> 		            
					</tr> 				
			    </tbody>
			</table> 
		</div>
	</div>
	<div class="col-md-1"></div>
</div>
<hr><h4 class="text text-info"><b>Menú de opciones:</b></h4> <br>
<div class="row" style="margin: 10px">
    <div class="col-md-1"></div>
    <div class="col-md-10"> 
    	<div class="btn-group btn-group-justified" style="opacity:0.8">
			<a target="_blank" href="<s:url action="showProductosHome" namespace="/actions/pubProductos" />" class="btn btn-primary" role="button">Sección Productos</a>
			<a href="<s:url action="seccionUsuario" namespace="/actions/socios" />" class="btn btn-primary" role="button">Sección Usuarios</a>
			<a href="<s:url action="showCambioPasswdForm" namespace="/actions/socios" />" class="btn btn-primary" role="button">Cambiar Constraseña</a>
		</div>
	</div>
	<div class="col-md-1"></div>
</div>

<%--  
	Validación del tipo de usuario que inicio sesión. Si la bandera 
	isAdmin es igual a true, se mostrará el menú de acciones de 
	administrador. 
--%>
<!-- <c:if test="${ sessionScope.isAdmin == true }">
		<p><a href="<s:url action="showAltaLibrosForm" namespace="/actions/socios" />" class="btn btn-default" role="button">Agregar libro</a></p>
</c:if> -->

<!-- <p>Búsqueda en el catálogo de libros</p> -->

