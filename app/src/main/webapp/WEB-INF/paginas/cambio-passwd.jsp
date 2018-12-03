<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h2>Cambio de contraseña</h2>
<hr> 
<p><a href="<s:url action="cpasswd" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8 col-xs-12"> 
		<s:form action="cpasswd" namespace="/actions/socios" method="POST" class="form-signin">
			<span id="reauth-email" class="reauth-email"></span>
			<s:fielderror/>
			<div class="form-group">
			    <label for="passwordActual">Contraseña actual:</label>
				<s:password id="passwordActual" name="frmCambioPasswd.passwdAnterior" class="form-control" placeholder="Contraseña anterior"></s:password>
			</div>
			<div class="form-group">
			    <label for="passwordNuevo">Contraseña nueva:</label>
				<s:password id="passwordNuevo" name="frmCambioPasswd.passwdNuevo" class="form-control" placeholder="Contraseña nueva"></s:password>
			</div>
			<div class="form-group">
			    <label for="passwordNuevoConfirm">Confirmar contraseña nueva:</label>
				<s:password id="passwordNuevoConfirm" name="frmCambioPasswd.passwdConfirmacion" class="form-control"  placeholder="Confirmación"></s:password>
			</div>
			<br><br>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<button type="submit" class="btn btn-primary">Guardar <span class="glyphicon glyphicon-save"></button>	
				</div>
				<div class="col-md-4"></div>
			</div>
			<br>

		</s:form>
	</div>
</div>


