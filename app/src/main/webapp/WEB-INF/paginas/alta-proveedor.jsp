<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<center><button class="btn btn-lg btn-block btn-danger"
					onclick="history.back(-1)">Atrás</button></center>
<div class="card card-container">
	<h3 id="profile-name" class="profile-name-card text-center">Registro de proveedor</h3>
	<br>
	
	<s:if test="%{proveedor.nombre==null}">
	        <s:form action="altaproveedor" namespace="/actions/socios" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				<s:fielderror/>
				<p>Nombre:</p>
				<s:textfield name="proveedor.nombre" class="form-control" placeholder="Nombre"></s:textfield>
				<p>Descripci&oacute;n:</p>
				<s:textfield name="proveedor.descripcion" class="form-control" placeholder="Descripcion"></s:textfield>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Registrar proveedor <span class="glyphicon glyphicon-ok"></span></button>
			</s:form>
	 </s:if>
	 
	 <s:else>
	        <s:form action="editarproveedor" namespace="/actions/socios" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				<s:fielderror/>
				<p>Nombre:</p>
				<s:textfield name="proveedor.nombre" class="form-control" placeholder="Nuevo nombre"></s:textfield>
				<p>Descripci&oacute;n:</p>
				<s:textfield name="proveedor.descripcion" class="form-control" placeholder="Descripcion"></s:textfield>
				<s:textfield name="proveedor.proveedor_id" class="form-control" cssStyle="visibility:hidden"></s:textfield>
				<s:textfield name="proveedor.fecha_creacion" class="form-control" cssStyle="visibility:hidden"></s:textfield>
				<button class="btn btn-lg btn-block btn-success"
					type="submit">Guardar proveedor <span class="glyphicon glyphicon-save"></span></button>
			</s:form>
	</s:else>
			
</div><!-- /card-container -->