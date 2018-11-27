<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="card card-container">
	<h3>Ingresa tus datos</h3>
	<s:form action="registro" method="post" class="form-signin">
		<span id="reauth-email" class="reauth-email"></span>
		<s:if test="hasFieldErrors()">
		<div class="alert alert-warning fade in">
			<a href="#" class="close" data-dismiss="alert">×</a> <strong><s:fielderror/></strong>
		</div>
		</s:if>
		<s:textfield name="usuario.mail" placeholder="usuario@dominio.com"></s:textfield>
		<s:textfield name="usuario.nombre" placeholder="Nombre"></s:textfield>
		<s:textfield name="usuario.apPaterno" placeholder="Apellido paterno"></s:textfield>
		<s:textfield name="usuario.apMaterno" placeholder="Apellido materno"></s:textfield>
		<s:password name="usuario.password" placeholder="Contraseña"></s:password>
		<s:password name="passwordConfirn" placeholder="Confirmación"></s:password>
		<button type="submit">Crear cuenta</button>
	</s:form>
</div><!--/.card card-container-->
