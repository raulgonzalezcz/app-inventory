<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="card card-container">
	<h3 id="profile-name" class="profile-name-card text-center">Registro de marca</h3>
	<br>
	<!-- <img id="profile-img" class="profile-img-card" src="images/inventory.jpg" /> -->
	<s:if test="%{marca.nombre==null}">
		<s:form action="altaMarca" namespace="/actions/socios" method="POST" class="form-signin">
			<span id="reauth-email" class="reauth-email"></span>
			<p>Nombre:</p>
			<s:textfield name="marca.nombre" class="form-control" placeholder="..."></s:textfield>
			<p>Descripción:</p>
			<s:textarea name="marca.descripcion" class="form-control" placeholder="..." ></s:textarea>
			<br>
			<button class="btn btn-lg btn-primary btn-block btn-signin"
				type="submit">Registrar <span class="glyphicon glyphicon-ok"></span></button>
		</s:form>		
	</s:if>	

	<s:else>
		<s:form action="editarMarca" namespace="/actions/socios" method="POST" class="form-signin">
			<!-- <p>Id:</p> -->
			<span id="reauth-email" class="reauth-email"></span>
			<s:textfield  name="marca.id" class="form-control" placeholder="..." disabled="false" cssStyle="visibility:hidden"></s:textfield>
			<s:textfield  name="marca.fecha" class="form-control" placeholder="..." disabled="false" cssStyle="visibility:hidden"></s:textfield>
			<s:textfield name="marca.nombre" class="form-control" placeholder="..."></s:textfield>
			<p>Descripción:</p>
			<s:textarea name="marca.descripcion" class="form-control" placeholder="..." ></s:textarea>
			<br>
			<button class="btn btn-lg btn-primary btn-block btn-signin"
				type="submit">Guardar <span class="glyphicon glyphicon-save"></span></button>
		</s:form>	
	</s:else>	
</div><!-- /card-container --> 
