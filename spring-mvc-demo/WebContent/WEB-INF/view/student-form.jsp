<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

	<meta charset="ISO-8859-1">
	<title>Student Form</title>

</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
	Primeiro nome: <form:input path="firstName"/>
	
	<br><br>
	
	�ltimo nome: <form:input path="lastName"/>
	
	<br><br>
	
	Country:
	
	<form:select path="country">
	
		<form:options items="${student.countryOptions}"/>
		
	</form:select>
	
	<br><br>
	
	<input type="submit" value="Submit">
	
	</form:form>

</body>

</html>