<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<div> 
	<h2>Marcas</h2>
	<hr>
	<center>
		<p><a href="<s:url action="altaMarcaPage" namespace="/actions/socios" />" class="btn btn-info" role="button">Agregar Marca <span class="glyphicon glyphicon-plus"></span></a> </p>
	</center>
	<hr>
	<table class="table table-hover table-responsive">
	    <thead>
	    	<tr>
	        	<th>#</th>
		        <th>Nombre</th>
		        <th>Fecha creación</th>
		        <th>Descripción</th>
		        <th></th>
	      	</tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${marcas}" var="marca"> 					 
				<tr>
					<td>${marca.id}</td>  
					<td>${marca.nombre}</td> 
					<td>${marca.fecha}</td> 
					<td>${marca.descripcion}</td> 		                
					<td style="text-align: right;" >	    		
			    		<a href="<s:url action="editarMarcaPage"  namespace="/actions/socios" > <s:param name="marca.id">${marca.id}</s:param> </s:url>" class="btn btn-primary" role="button">Editar <span class="glyphicon glyphicon-edit"></span></a>

			    		<a href="<s:url action="deleteMarca"  namespace="/actions/socios" > <s:param name="marca.id">${marca.id}</s:param> </s:url>" class="btn btn-danger" role="button">Eliminar <span class="glyphicon glyphicon-trash"></span></a>
			        </td>		            
				</tr> 				
			</c:forEach>
	    </tbody>
	  </table>			
</div><!-- /card-container -->
