<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:out value="This is out tag!"/>
<br/>
<c:out value="${9*8}"/>
<br/>

<c:set var="name" scope="session" value="jay1"/>
<c:out value="Value of name is : ${name}"/>
<br/>
<br/>

<c:if test="${name == 'jay1'}">
	<c:out value="Good name!"/>
</c:if>

<br/>
<br/>

<c:set var="gender" scope="session" value="female"/>
<c:choose>
    <c:when test="${gender == 'male'}">
       	<c:out value="Your gender is male."/>
    </c:when>
    <c:when test="${gender == 'female'}">
    	<c:out value="Your gender is female."/>
    </c:when>
    <c:otherwise>
	  	<c:out value="No Comments!"/>
    </c:otherwise>
</c:choose>


<br/>
<c:catch var ="myException">
   <% int ans = 99/0;%>
</c:catch>

<c:if test = "${myException != null}">
   <p>The exception is : ${myException} <br />
   Exception message: ${myException.message}</p>
</c:if>

<br/>
<br/>

<c:import var="siteData" url="NewFile.jsp"/>
<c:out value="siteData is : ${siteData}"/>

<br/>
<br/>

<c:forEach var="i" begin="1" end="7">
   <c:out value=" Iteration : ${i}"/><p>
</c:forEach>

<br/>
<br/>
<c:forTokens 
	items="jay@gmail.com,ash@gmail.com,tj@gmail.com" 
	delims="," var="name">
   <c:out value=" Tokens are : ${name}"/><p>
</c:forTokens>

<br/>
<br/>

<a href="<c:url value="NewFile.jsp"/>">Goto NewFile.jsp</a>

</body>
</html>