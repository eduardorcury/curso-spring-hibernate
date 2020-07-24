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
	
	Último nome: <form:input path="lastName"/>
	
	<br><br>
	
	Country:
	
	<form:select path="country">
	
		<form:options items="${student.countryOptions}"/>
		
	</form:select>
	
	<br><br>
	
	Favorite Language:
	
	Java <form:radiobutton path="favoriteLanguage" value="Java"/>
	C++ <form:radiobutton path="favoriteLanguage" value="C++"/>
	Kotlin <form:radiobutton path="favoriteLanguage" value="Kotlin"/>
	PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
	
	<br><br>
	
	Operating Systems:
	
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	MacOS <form:checkbox path="operatingSystems" value="MacOS"/>
	Windows <form:checkbox path="operatingSystems" value="Windows"/>
	
	<br><br>
	
	<input type="submit" value="Submit">
	
	</form:form>

</body>

</html>