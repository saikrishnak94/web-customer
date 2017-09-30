<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer-form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/CSS/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/CSS/add-customer-style.css">

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>

		<form:form action="saveCustomer"
			modelAttribute="customerAttributeName" method="POST">
			<form:hidden path="id" />
	First Name: <form:input path="firstname" />
			<br>
			<br>
	Last Name: <form:input path="lastname" />
			<br>
			<br>
	E-mail: <form:input path="email" />
			<br>
			<br>
			<input type="submit" value="Save" class="save">
		</form:form>

		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to list</a>
		</p>

	</div>
</body>
</html>