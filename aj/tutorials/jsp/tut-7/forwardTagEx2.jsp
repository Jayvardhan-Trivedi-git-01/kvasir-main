
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head>
        <title>JSP Include example with parameters</title>
    </head>
    <body> 
        <h2>This is main Page</h2>

        <h2>The content of page3.jsp  with parameters : </h2>

        <jsp:forward page="page3.jsp"> 
            <jsp:param name="userid" value="demouser" /> 
            <jsp:param name="password" value="marwadi" /> 
            <jsp:param name="name" value="my demo user name" /> 
            <jsp:param name="age" value="20" /> 
        </jsp:forward>> 
    </body> 
</html>
