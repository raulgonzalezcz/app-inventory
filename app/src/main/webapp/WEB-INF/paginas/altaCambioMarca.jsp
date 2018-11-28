<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="card card-container">
	<!-- <img id="profile-img" class="profile-img-card" src="images/inventory.jpg" /> -->
	<s:if test="%{marca.nombre==null}">
		<h3 style="color: blue" id="profile-name" class="profile-name-card text-center">Registro de marca</h3>
		<br>
		<s:form action="altaMarca" namespace="/actions/socios" method="POST" class="form-signin">
			<span id="reauth-email" class="reauth-email"></span>
			<p>Nombre:</p>
			<s:textfield name="marca.nombre" class="form-control" placeholder="..." required="required"></s:textfield>
			<p>Descripción:</p>
			<s:textarea name="marca.descripcion" class="form-control" placeholder="..."  required="required"></s:textarea>
			<br>
			<button class="btn btn-lg btn-primary btn-block btn-signin"
				type="submit">Registrar <span class="glyphicon glyphicon-ok"></span></button>
		</s:form>		
	</s:if>	

	<s:else>
		<h3 style="color: blue" id="profile-name" class="profile-name-card text-center">Editar almacén</h3>
		<s:form action="editarMarca" namespace="/actions/socios" method="POST" class="form-signin">
			<p>Nombre:</p>
			<s:textfield name="marca.nombre" class="form-control" placeholder="..." required="required"></s:textfield>
			<p>Descripción:</p>
			<s:textarea name="marca.descripcion" class="form-control" placeholder="..." required="required"></s:textarea>
			<s:textfield  name="marca.id" class="form-control" placeholder="..." disabled="false" cssStyle="visibility:hidden"></s:textfield>
			<s:textfield  name="marca.fecha" class="form-control" placeholder="..." disabled="false" cssStyle="visibility:hidden"></s:textfield>
			<button class="btn btn-lg btn-primary btn-block btn-signin"
				type="submit">Guardar <span class="glyphicon glyphicon-save"></span></button>
		</s:form>	
	</s:else>	
</div><!-- /card-container --> 
