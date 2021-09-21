<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Producto</title >
</head>
<body>
	<div>
		<form:form action="/producto/modificar" method="post" modelAttribute="producto">
			<input type="hidden" name="_method" value="put">
			<form:label path="id">id:</form:label>
			<form:input type="text" path="id"/><br>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="precio">precio:</form:label>
			<form:input type="text" path="precio"/><br>
			
			<form:label path="stock">stock:</form:label>
			<form:input type="text" path="stock"/><br>
			
			<form:label path="descripcion">descripcion:</form:label>
			<form:input type="text" path="descripcion"/><br>
			
			<input type="submit" value="Editar Venta">
		</form:form>
	</div>
</body>
</html>