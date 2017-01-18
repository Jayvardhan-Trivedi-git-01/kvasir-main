
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Data From File Demo</title>
    </head>
    <body>
        <h1>Here is the data from file : </h1>
        <%
            BufferedReader br = 
                    new BufferedReader
                    (new FileReader(application.getRealPath("/") + "name.txt"));
            StringBuilder sb = new StringBuilder();
            String line;

            while((line = br.readLine())!= null){
                sb.append(line+"\n");
            }
            %>
            <%=sb%>
    </body>
</html>
