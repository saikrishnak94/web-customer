<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>customers list</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/style.css" />
</head>
<body>
<img src="../images/IMG_5627.jpg">
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
		
		   <input type="button" value="Add Customer" 
		          onclick="window.location.href='showFormForAdd'; return false;" 
		          class="add-button" />
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>E-mail</th>
					<th>Action</th>
				</tr>

				<tr>
					<c:forEach var="CustomersAttributeName"
						items="${CustomersAttributeName}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${CustomersAttributeName.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${CustomersAttributeName.id}"/>
					</c:url>
						<tr>
							<td>${CustomersAttributeName.firstname}</td>
							<td>${CustomersAttributeName.lastname}</td>
							<td>${CustomersAttributeName.email}</td>
							<td><a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer'))) return false">Delete</td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>