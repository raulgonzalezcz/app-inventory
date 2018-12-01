<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<p><a href="<s:url action="showProductoHome" namespace="/actions/socios" />" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-arrow-left"></span> Atrás</a> </p>
<div class="card card-container">
	<h3 id="profile-name" class="profile-name-card text-center">Registro de producto</h3>
	<br>
	
	<s:if test="%{producto.marca==null}">
	        <s:form action="altaproducto" namespace="/actions/socios" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				<s:fielderror/>
				<p>Tipo:</p>
				<select name="idTipo">
					<c:forEach items="${tipos}" var="tipo">
						 <option value="${tipo.tipo_id}">${tipo.nombre}</option>
					</c:forEach> 
				</select>
				<p>Marca:</p>
				<select name="idMarca">
					<c:forEach items="${marcas}" var="marca">
						 <option value="${marca.id}">${marca.nombre}</option>
					</c:forEach> 
				</select>
				<p>Almacen:</p>
				<select name="idAlmacen">
					<c:forEach items="${almacenes}" var="almacen">
						 <option value="${almacen.id}">${almacen.nombre}</option>
					</c:forEach> 
				</select>
				<p>Proveedor:</p>
				<select name="idProveedor">
					<c:forEach items="${proveedores}" var="proveedor">
						 <option value="${proveedor.proveedor_id}">${proveedor.nombre}</option>
					</c:forEach> 
				</select>
				<p>Precio de venta:</p>
				<s:textfield min="0" type="number" step="0.01" name="producto.precio_venta" class="form-control" placeholder="..." required="required"></s:textfield>
				<p>Descripción:</p>
				<s:textarea maxlength="50" name="producto.descripcion" class="form-control" placeholder="..." required="required"></s:textarea>
				<p>Cantidad:</p>
				<s:textfield min="1" type="number" name="producto.cantidad" class="form-control" placeholder="..." required="required"></s:textfield>
				<p>Foto:</p>
				<s:textfield name="producto.foto" class="form-control" placeholder="..." required="required"></s:textfield>
				<p>Descuento (%):</p>
				<s:textfield type="number" min="0" max="100" name="producto.descuento" class="form-control" placeholder="..." required="required"></s:textfield>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Registrar producto <span class="glyphicon glyphicon-ok"></span></button>
			</s:form>
	 </s:if>
	 
	 <s:else>
	        <s:form action="editarproducto" namespace="/actions/socios" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				<s:fielderror/>
				
				<p>Tipo:</p>
				<select name="idTipo">
					<c:forEach items="${tipos}" var="tipo">
						<option value="${tipo.tipo_id}" <c:if test="${tipo.tipo_id == idTipo}"> selected </c:if>>${tipo.nombre}</option>
					</c:forEach> 
				</select>
				<p>Marca:</p>
				<select name="idMarca">
					<c:forEach items="${marcas}" var="marca">
						 <option value="${marca.id}" <c:if test="${marca.id == idMarca}"> selected </c:if>>${marca.nombre}</option>
					</c:forEach> 
				</select>
				<p>Almacen:</p>
				<select name="idAlmacen">
					<c:forEach items="${almacenes}" var="almacen">
						 <option value="${almacen.id}" <c:if test="${almacen.id == idAlmacen}"> selected </c:if>>${almacen.nombre}</option>
					</c:forEach> 
				</select>
				<p>Proveedor:</p>
				<select name="idProveedor">
					<c:forEach items="${proveedores}" var="proveedor">
						 <option value="${proveedor.proveedor_id}" <c:if test="${proveedor.proveedor_id == idProveedor}"> selected </c:if>>${proveedor.nombre}</option>
					</c:forEach> 
				</select>
				<p>Precio de venta:</p>
				<s:textfield min="0" type="number" step="0.01" name="producto.precio_venta" class="form-control" placeholder="..." required="required"></s:textfield>
				<p>Descripción:</p>
				<s:textarea maxlength="50" name="producto.descripcion" class="form-control" placeholder="..." required="required"></s:textarea>
				<p>Cantidad:</p>
				<s:textfield min="0" type="number" name="producto.cantidad" class="form-control" placeholder="..." required="required"></s:textfield>
				<p>Foto:</p>
				<s:textfield name="producto.foto" class="form-control" placeholder="..." required="required"></s:textfield>				
				<p>Descuento (%):</p>
				<s:textfield type="number" min="0" max="100" name="producto.descuento" class="form-control" placeholder="..." required="required"></s:textfield>
				<s:textfield name="producto.producto_id" class="form-control" cssStyle="visibility:hidden"></s:textfield>
				<s:textfield name="producto.fecha_creacion" class="form-control" cssStyle="visibility:hidden"></s:textfield>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Guardar producto <span class="glyphicon glyphicon-save"></span></button>
			</s:form>
	</s:else>
			
</div><!-- /card-container -->