<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="container">
  	<div class="jumbotron">
	    <h1>Bienvenidos a R&A Corp</h1> 
	    <p>Conoce la gran variedad de productos de marca que tenemos para ti, a un precio accesible y con grandes descuentos.</p> 
  	</div>

  	<div class="row text-center">
		<c:forEach items="${productos}" var="producto"> 	
			<div class="col-sm-3">
				<div class="card" style="width: 22rem; height: 275px">
				  <center><img style="width: 70px; height: 70px" class="card-img-top text-center" src="${producto.foto}" alt="Card image cap"></center>
				  <hr>
				  <div class="card-body">
				    <h5 class="card-title text-info">${producto.tipo.nombre} - ${producto.marca.nombre}</h5>
				    

				    <c:choose>
                        <c:when test="${producto.descuento!=0}">                       
                            <p class="card-text"><b>Precio:</b> $<span>${producto.precio_venta-producto.precio_venta*(producto.descuento/100)}</span></p>
                        </c:when>
                        <c:otherwise>
                        	<p class="card-text"><b>Precio:</b> $<span>${producto.precio_venta}</span></p>
                        </c:otherwise>
                    </c:choose>
				    	
				    <c:if test="%{producto.descuento==0}">
				    	<p class="card-text"><span class="label label-success"><b>Descuento: </b>${producto.descuento} %</span></p>
				    </c:if>


				    <c:choose>
                        <c:when test="${producto.descuento!=0 && producto.cantidad!=0}">                       
                            <p class="card-text"><span class="label label-success"><b>Descuento: </b>${producto.descuento} %</span></p>
                        </c:when>
                        <c:otherwise>
                        
                        </c:otherwise>
                    </c:choose>

				    <c:choose>
                        <c:when test="${producto.cantidad!=0}">                       
                            <p class="card-text"><b>Disponibles:</b> ${producto.cantidad}</p>
                        </c:when>
                        <c:otherwise>
                        	<p class="card-text"><span class="label label-warning">Producto Agotado</span></p>
                        </c:otherwise>
                    </c:choose>

				    <p class="card-text" title="${producto.descripcion}"><b>Descripción:</b><span >${producto.descripcion}</span></p>  
				  </div>
				</div>
			</div>
		</c:forEach>
	</div>
  

</div>

