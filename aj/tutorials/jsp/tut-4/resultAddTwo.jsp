
<%@page contentType="text/html" errorPage="showErrorView.jsp"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result of Add Two Numbers</title>
    </head>
    <body>
        <h1>The result is : </h1>
        <%
            String s1 = request.getParameter("num1");
            int x = Integer.parseInt(s1);
            String s2 = request.getParameter("num2");
            int y = Integer.parseInt(s2);
            int ans = x + y;
        %>
        <%=ans%>
    </body>
</html>
