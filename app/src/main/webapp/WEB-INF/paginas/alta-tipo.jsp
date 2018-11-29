<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<center><button class="btn btn-lg btn-block btn-danger"
					onclick="history.back(-1)">Atrás</button></center>
<div class="card card-container">
	<h3 id="profile-name" class="profile-name-card text-center">Registro de tipo</h3>
	<br>
	
	<s:if test="%{tipo.nombre==null}">
	        <s:form action="altatipo" namespace="/actions/socios" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				<s:fielderror/>
				<p>Nombre:</p>
				<s:textfield name="tipo.nombre" class="form-control" placeholder="Nombre" required="required"></s:textfield>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Registrar tipo <span class="glyphicon glyphicon-ok"></span></button>
			</s:form>
	 </s:if>
	 
	 <s:else>
	        <s:form action="editartipo" namespace="/actions/socios" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				<s:fielderror/>
				<p>Nombre:</p>
				<s:textfield name="tipo.nombre" class="form-control" placeholder="Nuevo nombre" required="required"></s:textfield>
				<s:textfield name="tipo.tipo_id" class="form-control" cssStyle="visibility:hidden"></s:textfield>
				<s:textfield name="tipo.fecha_creacion" class="form-control" cssStyle="visibility:hidden"></s:textfield>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Guardar tipo <span class="glyphicon glyphicon-save"></span></button>
			</s:form>
	</s:else>
			
</div><!-- /card-container -->