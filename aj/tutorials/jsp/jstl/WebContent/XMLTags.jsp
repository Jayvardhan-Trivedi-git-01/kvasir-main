<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="userlist">
  <users>
    <user>
      <username>jay</username>
      <pass>123</pass>
      <rights>admin</rights>
    </user>
    <user>
      <username>marwadi</username>
      <pass>admin</pass>
      <rights>student</rights>
    </user>
    <user>
      <username>Sony</username>
      <pass>444</pass>
      <rights>full</rights>
    </user>
  </users>
</c:set>

<x:parse xml="${userlist}" var="myusers"/>

  user name :  <x:out select="$myusers/users/user[1]/username"/><br/>
  user name :  <x:out select="$myusers/users/user[2]/username"/><br/>
  user name :  <x:out select="$myusers/users/user[3]/username"/><br/>
  
<br/>
<br/>
<x:if select="$myusers/users[1]/user/pass = '123'">
   <c:out value="Welcome back Jay!"/>
</x:if>  
  <br/>
  <br/>
  
  <x:forEach select="$myusers/users/user/username" var="names">
  Username Name:   <x:out select="$names" /><br/>
</x:forEach>
   <br/>
  <br/>
  
  
  <x:choose>
   <x:when select="$myusers/users/user/username = 'jay'">
      Welcome Jay!
   </x:when>
   <x:when select="$myusers/users/user/username = 'marwadi'">
        Welcome Marwadi!
   </x:when>
   <x:otherwise>
     Invalid user!
   </x:otherwise>
</x:choose>
  
</body>
</html>