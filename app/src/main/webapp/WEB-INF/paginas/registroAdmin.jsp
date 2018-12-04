<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h2>Registro de Usuario</h2>
<hr> 
<p><a href="<s:url action="seccionUsuario" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8 col-xs-12"> 
		<s:form action="registro" method="post" class="form-signin">
			<span id="reauth-email" class="reauth-email"></span>
			<s:if test="hasFieldErrors()">
			<div class="alert alert-warning fade in">
				<a href="#" class="close" data-dismiss="alert">×</a> <strong><s:fielderror/></strong>
			</div>
			</s:if>
			<div class="form-group">
			    <label for="correo">Correo:</label>
				<s:textfield id="correo" name="usuario.correo" class="form-control" placeholder="..." required="required"></s:textfield>
			</div>
			<div class="form-group">
			    <label for="nombre">Nombre:</label>
				<s:textfield id="nombre" name="usuario.nombre" class="form-control" placeholder="..." required="required"></s:textfield>
			</div>
			<div class="form-group">
			    <label for="apellidos">Apellido(s):</label>
				<s:textfield id="apellidos" name="usuario.apellidos" class="form-control" placeholder="..." required="required"></s:textfield>
			</div>
			<div class="form-group">
			    <label for="contrasena">Contraseña:</label>
				<s:password id="contrasena" name="usuario.contrasena" placeholder="" class="form-control" required="required"></s:password>
			</div>
			<div class="form-group">
			    <label for="confContrasena">Confirmar Contraseña:</label>
				<s:password id="confContrasena" name="passwordConfirn" placeholder="" class="form-control" required="required"></s:password>
			</div>
			<br><br>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<button type="submit" class="btn btn-primary">Crear cuenta <span class="glyphicon glyphicon-ok"></button>	
				</div>
				<div class="col-md-4"></div>
			</div>
			<br>
		</s:form>
	</div>
</div>


