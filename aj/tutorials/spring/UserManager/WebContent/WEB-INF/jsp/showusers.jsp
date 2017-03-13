<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show User Screen</title>
</head>
<body>

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
<br/>
<a href="listusers">View All Users</a>
</body>
</html>