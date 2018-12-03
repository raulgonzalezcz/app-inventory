<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>

	
	<s:if test="%{producto.marca==null}"> 
		
		<h2>Registro de Producto</h2>
		<hr> 
		<p><a href="<s:url action="showProductoHome" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
		<div class="row">
			<div class="col-md-2"></div>
    		<div class="col-md-8 col-xs-12"> 
		        <s:form action="altaproducto" namespace="/actions/socios" method="POST" class="form-signin">
					<span id="reauth-email" class="reauth-email"></span>
					<s:fielderror/>

					<div class="form-group">
					    <label for="idTipo">Tipo:</label>
						<select class="form-control" id="idTipo" name="idTipo" required="required">
							<option disabled selected value> - selecciona una opción - </option>
						    <c:forEach items="${tipos}" var="tipo">
								<option value="${tipo.tipo_id}">${tipo.nombre}</option>
							</c:forEach> 
						</select>
					</div>
					<div class="form-group">
					    <label for="idMarca">Marca:</label>
						<select class="form-control" id="idMarca" name="idMarca" required="required">
							<option disabled selected value> - selecciona una opción - </option>
						    <c:forEach items="${marcas}" var="marca">
								<option value="${marca.id}">${marca.nombre}</option>
							</c:forEach> 
						</select>
					</div>
					<div class="form-group">
					    <label for="idAlmacen">Almacén:</label>
						<select class="form-control" id="idAlmacen" name="idAlmacen" required="required">
							<option disabled selected value> - selecciona una opción - </option>
						    <c:forEach items="${almacenes}" var="almacen">
								<option value="${almacen.id}">${almacen.nombre}</option>
							</c:forEach> 
						</select>
					</div>
					<div class="form-group">
					    <label for="idProveedor">Proveedor:</label>
						<select class="form-control" id="idProveedor" name="idProveedor" required="required">
							<option disabled selected value> - selecciona una opción - </option>
						    <c:forEach items="${proveedores}" var="proveedor">
								<option value="${proveedor.proveedor_id}">${proveedor.nombre}</option>
							</c:forEach> 
						</select>
					</div>

					<div class="form-group">
					    <label for="precioVenta">Precio de venta:</label>
						<s:textfield min="0" type="number" step="0.01" id="precioVenta" name="producto.precio_venta" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<div class="form-group">
					    <label for="descuento">Descuento(%):</label>
						<s:textfield id="descuento" type="number" min="0" max="100" name="producto.descuento" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<div class="form-group">
					    <label for="descripcion">Descripción:</label>
						<s:textarea id="descripcion" maxlength="50" name="producto.descripcion" class="form-control" placeholder="..." required="required"></s:textarea>
					</div>
					<div class="form-group">
					    <label for="cantidad">Cantidad:</label>
						<s:textfield id="cantidad" min="1" type="number" name="producto.cantidad" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<div class="form-group">
					    <label for="foto">Foto:</label>
						<s:textfield id="foto" name="producto.foto" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<br>
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
			<div class="col-md-2"></div>
		</div>
	</s:if>
	 
	<s:else>
	 	<h2>Editar Producto <span style="font-size: 50%">id= <span class="text-primary">${producto.producto_id}</span></span></h2>
		<hr> 
		<p><a href="<s:url action="showProductoHome" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
		<div class="row">
			<div class="col-md-2"></div>
    		<div class="col-md-8 col-xs-12"> 
		        <s:form action="editarproducto" namespace="/actions/socios" method="POST" class="form-signin">
					<span id="reauth-email" class="reauth-email"></span>
					<s:fielderror/>

					<div class="form-group">
					    <label for="idTipo">Tipo:</label>
						<select class="form-control" id="idTipo" name="idTipo" required="required">
							<option disabled selected value> - selecciona una opción - </option>
						    <c:forEach items="${tipos}" var="tipo">
								<option value="${tipo.tipo_id}" <c:if test="${tipo.tipo_id == idTipo}"> selected </c:if>>${tipo.nombre}</option>
							</c:forEach> 
						</select>
					</div>
					<div class="form-group">
					    <label for="idMarca">Marca:</label>
						<select class="form-control" id="idMarca" name="idMarca" required="required">
							<option disabled selected value> - selecciona una opción - </option>
						    <c:forEach items="${marcas}" var="marca">
								<option value="${marca.id}" <c:if test="${marca.id == idMarca}"> selected </c:if>>${marca.nombre}</option>
							</c:forEach> 
						</select>
					</div>
					<div class="form-group">
					    <label for="idAlmacen">Almacén:</label>
						<select class="form-control" id="idAlmacen" name="idAlmacen" required="required">
							<option disabled selected value> - selecciona una opción - </option>
						    <c:forEach items="${almacenes}" var="almacen">
								<option value="${almacen.id}" <c:if test="${almacen.id == idAlmacen}"> selected </c:if>>${almacen.nombre}</option>
							</c:forEach> 
						</select>
					</div>
					<div class="form-group">
					    <label for="idProveedor">Proveedor:</label>
						<select class="form-control" id="idProveedor" name="idProveedor" required="required">
							<option disabled selected value> - selecciona una opción - </option>
						    <c:forEach items="${proveedores}" var="proveedor">
								<option value="${proveedor.proveedor_id}" <c:if test="${proveedor.proveedor_id == idProveedor}"> selected </c:if>>${proveedor.nombre}</option>
							</c:forEach> 
						</select>
					</div>

					<div class="form-group">
					    <label for="precioVenta">Precio de venta:</label>
						<s:textfield min="0" step="0.01" id="precioVenta" name="producto.precio_venta" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>

					<div class="form-group">
					    <label for="descuento">Descuento(%):</label>
						<s:textfield id="descuento" type="number" min="0" max="100" name="producto.descuento" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<div class="form-group">
					    <label for="descripcion">Descripción:</label>
						<s:textarea id="descripcion" maxlength="50" name="producto.descripcion" class="form-control" placeholder="..." required="required"></s:textarea>
					</div>
					<div class="form-group">
					    <label for="cantidad">Cantidad:</label>
						<s:textfield id="cantidad" min="1" type="number" name="producto.cantidad" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<div class="form-group">
					    <label for="foto">Foto:</label>
						<s:textfield id="foto" name="producto.foto" class="form-control" placeholder="..." required="required"></s:textfield>
					</div>
					<center>
						<div style="width: 150px; height: 150px;">
							<img  class="img-thumbnail img-responsive" src="${producto.foto}" alt="Card image cap"/>
						</div>
					</center>

					<s:textfield name="producto.producto_id" class="form-control" cssStyle="visibility:hidden"></s:textfield>
					<s:textfield name="producto.fecha_creacion" class="form-control" cssStyle="visibility:hidden"></s:textfield>

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
			