<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Inicio login.jsp --> 
<center>
	<h2>Control de Inventario</h2>
</center>
<div class="card card-container">
	<img id="profile-img" class="profile-img-card"
		src="/images/inventory.jpg" />
	<p id="profile-name" class="profile-name-card">Log in</p>
	<%-- Manejo de mensajes --%> 
	<s:set var="bandera" value="flag" />
	<!-- <s:if test="%{#bandera=='logout'}">
		<div class="alert alert-success fade in">
			<a href="#" class="close" data-dismiss="alert">×</a> <strong>Su
				sesi&oacute;n ha sido cerrada</strong>
		</div>
	</s:if> -->
	<%-- Verificación de la existencia de algun error generado en el controlador y
		 registrado a través de la función addActionError 
	--%>
	<s:if test="hasActionErrors()">
		<div class="alert alert-danger fade in">
			<a href="#" class="close" data-dismiss="alert">×</a> <strong><s:actionerror /></strong>
		</div>
	</s:if>
	<!-- Inicio forma -->
	<s:form action="login" method="POST" class="form-signin">
		<span id="reauth-email" class="reauth-email"></span>
		<p>Correo:</p>
		<s:textfield name="frmLogin.correo" label="correo" class="form-control"
			placeholder="usuario@dominio.com" autofocus="true" />
		<p>Contraseña:</p>
		<s:password name="frmLogin.contrasena" label="contrasena"
			class="form-control" placeholder="Contraseña" />
		<br>
		<button class="btn btn-lg btn-primary btn-block btn-signin"
			type="submit">Ingresar </button>

	</s:form>
	<!-- Fin forma -->
	<!-- <p>
		<a href='<s:url action="showRegisterForm" />' class="forgot-password">¿A&uacute;n
			no eres usuariooo?</a>
	</p> -->
</div><!-- /card-container -->
<!-- fin login.jsp -->