<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<tiles:insertAttribute name="styles" />
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
 <body>
    <div class="container">
    	<tiles:insertAttribute name="body" />
	</div><!--/.container -->
</body>
</html>