<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pagina de Registro</title>
</head>
<body>
    <h1>Registrate!</h1>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registrar" modelAttribute="user">
    	<p>
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/>
        </p>
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Confirmación Password:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Registrate!"/>
    </form:form>
    
</body>
</html>