<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="card card-container">
	<h3>Registro de tipo</h3>
	
	<s:if test="%{tipo.nombre==null}">
	        <s:form action="altatipo" namespace="/actions/socios" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				<s:fielderror/>
				<s:textfield name="tipo.nombre" class="form-control" placeholder="Nombre"></s:textfield>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Registrar tipo</button>
			</s:form>
	 </s:if>
	 
	 <s:else>
	        <s:form action="cambiotipo" namespace="/actions/socios" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				<s:fielderror/>
				<s:textfield name="tipo.id" class="form-control" cssStyle="visibility:hidden"></s:textfield>
				<s:textfield name="tipo.nombre" class="form-control" placeholder="Nuevo nombre"></s:textfield>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Actualizar tipo</button>
			</s:form>
	</s:else>
			
</div><!-- /card-container -->