<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<title>Spring Patients</title>
</head>
 
<body bgcolor='#<c:out value="${colorcode}" />'>
 
<h1>Spring Patients</h1>
 
<c:if test="${not empty patientlist}" >
	<c:forEach items="${patientlist}" var="patient">		
			<br/><b>@Anonymous</b> says<br/>	
			on <c:out value="${patient.patientDate}" /><br/>	
			<c:out value="${patient.patientText}" /><br/>			
	</c:forEach>	
</c:if>
<c:if test="${empty patientlist}" >
	There are no patients yet. 
</c:if>
 
<p><a href="/SpringPatient/home/addpatient.html">Add patient</a><br/>
<a href="/SpringPatient/">Home</a>
 
</body>
</html>