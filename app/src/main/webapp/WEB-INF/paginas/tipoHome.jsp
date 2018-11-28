<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div> 
	<h2>Tipos</h2>
	<hr>
	<center>
		<p><a href="<s:url action="showAltaTiposForm" namespace="/actions/socios" />" class="btn btn-info" role="button">Agregar tipo <span class="glyphicon glyphicon-plus"></span></a> </p>
	</center>
	<hr>
	<table class="table table-hover table-responsive">
	    <thead>
	    	<tr>
	        	<th>#</th>
		        <th>Nombre</th>
		        <th>Fecha</th>
		        <th></th>
	      	</tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${tipos}" var="tipo"> 					 
				<tr>
					<td>${tipo.tipo_id}</td>  
					<td>${tipo.nombre}</td> 
					<td>${tipo.fecha_creacion}</td> 	                
					<td style="text-align: right;" >
			    		<a href="<s:url action="showEditarTipoForm" namespace="/actions/socios" > <s:param name="tipo.tipo_id">${tipo.tipo_id}</s:param> </s:url>" class="btn btn-primary" role="button">Editar <span class="glyphicon glyphicon-edit"></span></span></a>
			    		<a href="<s:url action="bajatipo" namespace="/actions/socios" > <s:param name="tipo.tipo_id">${tipo.tipo_id}</s:param> </s:url>" class="btn btn-danger" role="button">Eliminar <span class="glyphicon glyphicon-trash"></span></a>

			        </td>		            
				</tr> 				
			</c:forEach>
	    </tbody>
	  </table>			
</div><!-- /card-container -->
