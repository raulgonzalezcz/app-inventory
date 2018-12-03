<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>


	<s:if test="%{marca.nombre==null}">
		<h2>Registro de Marca</h2>
		<hr> 
		<p><a href="<s:url action="seccionMarca" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
		<div class="row">
			<div class="col-md-2"></div>
    		<div class="col-md-8 col-xs-12"> 

				<s:form action="altaMarca" namespace="/actions/socios" method="POST" class="form-signin">
					<span id="reauth-email" class="reauth-email"></span>
					<div class="form-group">
					    <label for="nombre">Nombre:</label>
						<s:textfield id="nombre" name="marca.nombre" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<div class="form-group">
					    <label for="descripcion">Descripción:</label>
						<s:textarea id="descripcion" name="marca.descripcion" class="form-control" placeholder="..."  required="required"></s:textarea>
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
		<h2>Editar Marca <span style="font-size: 50%">id= <span class="text-primary">${marca.id}</span></span></h2>
		<hr> 
		<p><a href="<s:url action="showTipoHome" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
		<div class="row">
			<div class="col-md-2"></div>
    		<div class="col-md-8 col-xs-12"> 
				<s:form action="editarMarca" namespace="/actions/socios" method="POST" class="form-signin">
					<div class="form-group">
					    <label for="nombre">Nombre:</label>
						<s:textfield id="nombre" name="marca.nombre" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<div class="form-group">
					    <label for="descripcion">Descripción:</label>
						<s:textarea id="descripcion" name="marca.descripcion" class="form-control" placeholder="..."  required="required"></s:textarea>
					</div>
					<s:textfield  name="marca.id" class="form-control" placeholder="..." disabled="false" cssStyle="visibility:hidden"></s:textfield>
					<s:textfield  name="marca.fecha" class="form-control" placeholder="..." disabled="false" cssStyle="visibility:hidden"></s:textfield>
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
</div><!-- /card-container --> 
