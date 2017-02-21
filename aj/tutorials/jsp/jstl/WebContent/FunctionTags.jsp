<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Function Tags</title>
</head>
<body>
<c:set var="college" value="marwadi education foundation"/>  
var college is :  <c:out value="${college}"></c:out> 
 
 <br/><br/>
<c:if test="${fn:contains(college, 'education')}">  
   user string contains education!
</c:if>  

<br/><br/>

<c:if test="${fn:containsIgnoreCase(college, 'eDuCaTiON')}">  
   user string contains eDuCaTiON! 
</c:if>  
<br/><br/>

Word Education index in user is : 
${fn:indexOf(college, "education")}
<br/><br/>
<c:set var="college2" value="     marwadi   education foundation    "/>  
var college2 is :  <c:out value="${college2}"></c:out>
<br/><br/> 
<c:out value="${fn:trim(college2)}"/>
<br/><br/> 

<c:if test="${fn:startsWith(college, 'marwadi')}" >
College is Marwadi!
</c:if>

<br/><br/> 
<c:set var="college4" value="marawdi/education/foundation"/>  
<c:set var="college5" value="${fn:split(college4, '/')}" />  
<c:set var="college6" value="${fn:join(college5, '+')}" />  
  
Final college name : ${college6}  

<br/><br/> 
Length is : ${fn:length(college)}<br/>
Substring is :${fn:substring(college, 7, 28)}  <br/>
Replaced College : ${fn:replace(college, "marwadi", "rajkot")}<br/>

<c:set var="college7" value="marwadi education foundation of marwadi"/>  
Replaced College : ${fn:replace(college7, "marwadi", "rajkot")}<br/>
  
  
  
</body>
</html>