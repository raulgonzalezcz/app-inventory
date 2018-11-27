<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="card card-container">
	<h3>Cambio de contraseña</h3>
	<s:form action="cpasswd" namespace="/actions/socios" method="POST" class="form-signin">
		<span id="reauth-email" class="reauth-email"></span>
		<s:fielderror/>
		<s:password name="frmCambioPasswd.passwdAnterior" class="form-control" placeholder="Contraseña anterior"></s:password>
		<s:password name="frmCambioPasswd.passwdNuevo" class="form-control" placeholder="Contraseña nueva"></s:password>
		<s:password name="frmCambioPasswd.passwdConfirmacion" class="form-control"  placeholder="Confirmación"></s:password>
		<button class="btn btn-lg btn-primary btn-block btn-signin"
			type="submit">Cambiar contraseña</button>
	</s:form>			
</div><!-- /card-container -->