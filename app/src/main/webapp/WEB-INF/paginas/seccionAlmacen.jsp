<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<div> 
	<h2>Almacén</h2>
	<hr>
	<center>
		<p><a href="<s:url action="altaAlmacenPage" namespace="/actions/socios" />" class="btn btn-info" role="button">Agregar Almacén <span class="glyphicon glyphicon-plus"></span></a> </p>
	</center>
	<hr>
	<table class="table table-hover table-responsive">
	    <thead>
	    	<tr>
	        	<th>#</th>
		        <th>Nombre</th>
		        <th>Ubicación</th>
		        <th>Dimensión</th>
		        <th>Fecha creación</th>
		        <th></th>
	      	</tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${almacenes}" var="almacen"> 					 
				<tr>
					<td>${almacen.id}</td>  
					<td>${almacen.nombre}</td> 
					<td>${almacen.ubicacion}</td> 
					<td>${almacen.dimension} m<sup>2</sup></td> 
					<td>${almacen.fecha}</td> 
							                
					<td style="text-align: right;" >	    		
			    		<a href="<s:url action="editarAlmacenPage"  namespace="/actions/socios" > <s:param name="almacen.id">${almacen.id}</s:param> </s:url>" class="btn btn-primary" role="button">Editar <span class="glyphicon glyphicon-edit"></span></a>

			    		<a href="<s:url action="deleteAlmacen"  namespace="/actions/socios" > <s:param name="almacen.id">${almacen.id}</s:param> </s:url>" class="btn btn-danger" role="button">Eliminar <span class="glyphicon glyphicon-trash"></span></a>
			        </td>		            
				</tr> 				
			</c:forEach>
	    </tbody>
	  </table>			
</div><!-- /card-container -->
