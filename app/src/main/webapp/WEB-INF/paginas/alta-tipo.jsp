<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>

	
	<s:if test="%{tipo.nombre==null}">
		<h2>Registro de Tipo</h2>
		<hr> 
		<p><a href="<s:url action="showTipoHome" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
		<div class="row">
			<div class="col-md-2"></div>
    		<div class="col-md-8 col-xs-12"> 
		        <s:form action="altatipo" namespace="/actions/socios" method="POST" class="form-signin">
					<span id="reauth-email" class="reauth-email"></span>
					<s:fielderror/>
					<div class="form-group">
					    <label for="nombre">Nombre:</label>
						<s:textfield id="nombre" name="tipo.nombre" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<br><br>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<button type="submit" class="btn btn-primary">Registrar <span class="glyphicon glyphicon-ok"></button>	
						</div>
						<div class="col-md-4"></div>
					</div>
					<br>
				</s:form>
			</div>
		</div>
	 </s:if> 
	 
	 <s:else>
	 	<h2>Editar Tipo <span style="font-size: 50%">id= <span class="text-primary">${tipo.tipo_id}</span></span></h2>
		<hr> 
		<p><a href="<s:url action="showTipoHome" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
		<div class="row">
			<div class="col-md-2"></div>
    		<div class="col-md-8 col-xs-12"> 
		        <s:form action="editartipo" namespace="/actions/socios" method="POST" class="form-signin">
					<span id="reauth-email" class="reauth-email"></span>
					<s:fielderror/>
					<div class="form-group">
					    <label for="nombre">Nombre:</label>
						<s:textfield id="nombre" name="tipo.nombre" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<s:textfield name="tipo.tipo_id" class="form-control" cssStyle="visibility:hidden"></s:textfield>
					<s:textfield name="tipo.fecha_creacion" class="form-control" cssStyle="visibility:hidden"></s:textfield>
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

	</s:else>
			
