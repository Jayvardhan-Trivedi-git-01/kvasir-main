<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" action="/UserManager/addUser">

				<table>
					    <tr>
					        <td><form:label path="userID">ID</form:label></td>
					        <td><form:input path="userID"/></td>
					    </tr>
					<tr>
						<td><form:label path="userName">Name</form:label></td>
						<td><form:input path="userName" /></td>
					</tr>
					<tr>
						<td><form:label path="userPass">Password</form:label></td>
						<td><form:input path="userPass" /></td>
					</tr>
					    <tr>
					        <td><form:label path="isAuthenticated">Valid user</form:label></td>
					        <td><form:checkbox path="isAuthenticated"/></td>
					    </tr>
					<tr>
						<td colspan="2"><input type="submit" value="AddUser" /></td>
					</tr>
				</table>

			</form:form>
</body>
</html>