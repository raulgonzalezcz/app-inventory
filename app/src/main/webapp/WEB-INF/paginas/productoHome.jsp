<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div> 
	<h2>Productos</h2>
	<hr>
	<center>
		<p><a href="<s:url action="showAltaProductosForm" namespace="/actions/socios" />" class="btn btn-info" role="button">Agregar producto <span class="glyphicon glyphicon-plus"></span></a> </p>
	</center>
	<hr>
	<table class="table table-hover table-responsive">
	    <thead>
	    	<tr>
	        	<th>#</th>
		        <th>Tipo</th>
		        <th>Marca</th>
		        <th>Almacen</th>
		        <th>Proveedor</th>
		        <th>Precio de venta</th>
		        <th>Descripci&oacute;n</th>
		        <th>Cantidad</th>
		        <th>Descuento</th>
		        <th>Fecha de creación</th>
		        <th></th>
	      	</tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${productos}" var="producto"> 					 
				<tr>
					<td>${producto.producto_id}</td>
					<td>${producto.tipo.nombre}</td>  
					<td>${producto.marca.nombre}</td>
					<td>${producto.almacen.nombre}</td>
					<td>${producto.proveedor.nombre}</td> 
					<td>${producto.precio_venta}</td>
					<td>${producto.descripcion}</td>
					<td>${producto.cantidad}</td>
					<td>${producto.descuento}</td>
					<td>${producto.fecha_creacion}</td> 	                
					<td style="text-align: right;" >
			    		<a href="<s:url action="showEditarProductoForm" namespace="/actions/socios" > <s:param name="producto.producto_id">${producto.producto_id}</s:param> </s:url>" class="btn btn-primary" role="button">Editar <span class="glyphicon glyphicon-edit"></span></span></a>
			    		<a href="<s:url action="bajaproducto" namespace="/actions/socios" > <s:param name="producto.producto_id">${producto.producto_id}</s:param> </s:url>" class="btn btn-danger" role="button">Eliminar <span class="glyphicon glyphicon-trash"></span></a>

			        </td>		            
				</tr> 				
			</c:forEach>
	    </tbody>
	  </table>			
</div><!-- /card-container -->
