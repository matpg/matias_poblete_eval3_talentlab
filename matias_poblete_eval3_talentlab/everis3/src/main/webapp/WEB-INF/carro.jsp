<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito de Compras</title>
</head>
<body>
	<table>
	<thead>
		<h1>Carrito de Compras</h1>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="producto" items="${lista_carrito}" >
		<tr>
			<td ><c:out value="${producto.key}" /></td>
			<td ><c:out value="${producto.value}" /> </td>
			<td>
				<form action="/producto/eliminarcarrito" method="POST">
					<input type="hidden" name="nombre" value="<c:out value="${producto.key}" />">
					<input type="hidden" name="precio" value="<c:out value="${producto.value}" />"> 
					<input type="submit" value="Eliminar Prod">
				</form>
			</td>
		</tr>
		</c:forEach>	
	</tbody>
</table>
		<h3>
			<td>Precio Total: <c:out value="${precio_total}" /> </td>
		</h3>
</body>
</html>