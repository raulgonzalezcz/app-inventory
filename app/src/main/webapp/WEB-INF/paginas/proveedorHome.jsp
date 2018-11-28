<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div> 
	<h2>Proveedores</h2>
	<hr>
	<center>
		<p><a href="<s:url action="showAltaProveedoresForm" namespace="/actions/socios" />" class="btn btn-info" role="button">Agregar proveedor <span class="glyphicon glyphicon-plus"></span></a> </p>
	</center>
	<hr>
	<table class="table table-hover table-responsive">
	    <thead>
	    	<tr>
	        	<th>#</th>
		        <th>Nombre</th>
		        <th>Descripci&oacute;n</th>
		        <th>Fecha de creación</th>
		        <th></th>
	      	</tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${proveedores}" var="proveedor"> 					 
				<tr>
					<td>${proveedor.proveedor_id}</td>  
					<td>${proveedor.nombre}</td>
					<td>${proveedor.descripcion}</td>  
					<td>${proveedor.fecha_creacion}</td> 	                
					<td style="text-align: right;" >
			    		<a href="<s:url action="showEditarProveedorForm" namespace="/actions/socios" > <s:param name="proveedor.proveedor_id">${proveedor.proveedor_id}</s:param> </s:url>" class="btn btn-primary" role="button">Editar <span class="glyphicon glyphicon-edit"></span></span></a>
			    		<a href="<s:url action="bajaproveedor" namespace="/actions/socios" > <s:param name="proveedor.proveedor_id">${proveedor.proveedor_id}</s:param> </s:url>" class="btn btn-danger" role="button">Eliminar <span class="glyphicon glyphicon-trash"></span></a>

			        </td>		            
				</tr> 				
			</c:forEach>
	    </tbody>
	  </table>			
</div><!-- /card-container -->
