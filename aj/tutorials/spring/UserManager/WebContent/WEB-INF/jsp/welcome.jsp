<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success : Add user</title>
</head>
<body>

	<br />


	<c:choose>
		<c:when test="${isAuthenticated eq true}">
			<c:out value="Welcome back ${userName}"></c:out>
			<br />
			<br />
Your Details are : 
  <table>
				<tr>
					<td>Name</td>
					<td>${userName}</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>${userPass}</td>
				</tr>
				<tr>
					<td>ID</td>
					<td>${userID}</td>
				</tr>
				<tr>
					<td>Valid</td>
					<td>${isAuthenticated}</td>
				</tr>
			</table>

			<br />
			<br />

			<a href="addNewUser">Add a new user</a>


		</c:when>
		<c:otherwise>
			<c:out value="Invalid Username/Password."></c:out>
		</c:otherwise>
	</c:choose>




</body>
</html>