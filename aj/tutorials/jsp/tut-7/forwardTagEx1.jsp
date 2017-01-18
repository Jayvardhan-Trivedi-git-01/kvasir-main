
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head>
        <title>JSP Include example without parameters</title>
    </head>
    <body>
        <h1>This content is in current page.</h1>
        <b>Page2.jsp content is : </b><br>
        <jsp:forward page="page2.jsp" /> 
    </body> 
</html>
