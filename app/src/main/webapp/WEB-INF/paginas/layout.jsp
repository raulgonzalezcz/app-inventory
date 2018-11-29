<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<tiles:insertAttribute name="styles" />
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
 <body>
    <div class="container">
      <!-- Static navbar -->
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<s:url action="showInicio" namespace="/actions/socios"/>">Control de Inventario</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="<s:url action="showInicio" namespace="/actions/socios"/>">Home</a></li>
            
              <li><a href="<s:url action="seccionMarca" namespace="/actions/socios"/>">Marca</a></li>
              <li><a href="<s:url action="showTipoHome" namespace="/actions/socios"/>">Tipo</a></li>
              <li><a href="<s:url action="showProveedorHome" namespace="/actions/socios"/>">Proveedor</a></li>
              <li><a href="<s:url action="seccionAlmacen" namespace="/actions/socios"/>">Almac&eacute;n</a></li>
              <li><a href="<s:url action="" namespace="/actions/socios"/>">Productos</a></li>
            </ul> 
            <ul class="nav navbar-nav navbar-right">
              <li><a href="<s:url action="logout" namespace="/actions/socios"/>"> <span class="glyphicon glyphicon-log-out"></span> Cerrar Sesi&oacute;n </a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
      <!-- Contenido de la página -->
      <tiles:insertAttribute name="body" />
      <!-- Fin contenido de la página -->
	</div> <!-- /container -->
</body>
</html>