
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Display Page</title>
    </head>
    <body>
        <h2>Hello, this is page3.jsp Page</h2>
        UserID: <%=request.getParameter("userid")%><br>
        Password is: <%=request.getParameter("password")%><br>
        User Name: <%=request.getParameter("name")%><br>
        Age: <%=request.getParameter("age")%>
    </body>
</html>
