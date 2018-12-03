<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>

	
	<s:if test="%{proveedor.nombre==null}">
		<h2>Registro de Proovedor</h2>
		<hr> 
		<p><a href="<s:url action="showProveedorHome" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
		<div class="row">
			<div class="col-md-2"></div>
    		<div class="col-md-8 col-xs-12"> 

		        <s:form action="altaproveedor" namespace="/actions/socios" method="POST" class="form-signin">
					<span id="reauth-email" class="reauth-email"></span>
					<s:fielderror/>
					<div class="form-group">
					    <label for="nombre">Nombre:</label>
						<s:textfield id="nombre" name="proveedor.nombre" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<div class="form-group">
					    <label for="descripcion">Nombre:</label>
						<s:textarea id="descripcion" name="proveedor.descripcion" class="form-control" placeholder="..." required="required"></s:textarea>
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
	 	<h2>Editar Proveedor <span style="font-size: 50%">id= <span class="text-primary">${proveedor.proveedor_id}</span></span></h2>
		<hr> 
		<p><a href="<s:url action="showTipoHome" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
		<div class="row">
			<div class="col-md-2"></div>
    		<div class="col-md-8 col-xs-12"> 

		        <s:form action="editarproveedor" namespace="/actions/socios" method="POST" class="form-signin">
					<span id="reauth-email" class="reauth-email"></span>
					<s:fielderror/>
					<div class="form-group">
					    <label for="nombre">Nombre:</label>
						<s:textfield id="nombre" name="proveedor.nombre" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<div class="form-group">
					    <label for="descripcion">Nombre:</label>
						<s:textarea id="descripcion" name="proveedor.descripcion" class="form-control" placeholder="..." required="required"></s:textarea>
					</div>
					<s:textfield name="proveedor.proveedor_id" class="form-control" cssStyle="visibility:hidden"></s:textfield>
					<s:textfield name="proveedor.fecha_creacion" class="form-control" cssStyle="visibility:hidden"></s:textfield>
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
			
