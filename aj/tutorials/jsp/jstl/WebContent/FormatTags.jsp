<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="studentMarks" value="95.75" />
<br/>
<fmt:formatNumber type="NUMBER" 
            value="${studentMarks}" />
<br/>
<fmt:formatNumber type="CURRENCY" 
            value="${studentMarks}" />
<br/>
<fmt:formatNumber type="PERCENT" 
            value="${studentMarks}" />
<br/>
<fmt:formatNumber type="NUMBER" 
             maxFractionDigits="1" value="${studentMarks}" />
<br/>
<fmt:parseNumber var="i" type="number" value="${studentMarks}" />
 <c:out value=" i is : ${i}" />

<br/>
<fmt:parseNumber var="i" integerOnly="true" 
                       type="number" value="${studentMarks}" />
<c:out value="i is : ${i}" />

<br/>
<br/>

<c:set var="myDate" value="<%=new java.util.Date()%>" />

 <fmt:formatDate type="DATE" 
            value="${myDate}" />
<br/>
<fmt:formatDate type="TIME" 
            value="${myDate}" />
<br/>
<fmt:formatDate type="BOTH" 
            value="${myDate}" /><br/><br/>

<c:set var="userName" value="jay"/>
<c:set var="userName2" value="jay2"/>


<fmt:setLocale value="EN_US"/>
<fmt:bundle basename="com.users.LocaleString_EN_US">
<c:if test="${userName =='jay'}">
<fmt:message key="user.goodLogin" /><br/>
</c:if>
</fmt:bundle>

<fmt:setLocale value="ES_FR"/>
<fmt:bundle basename="com.users.LocaleString_ES_FR">
<c:if test="${userName2 =='jay2'}">
<fmt:message key="user.badLogin" /><br/>
</c:if>
</fmt:bundle>

<br/>
<br/>

<c:set var="indiaTimeZone" value="<%=java.util.TimeZone.getDefault()%>"/>
<c:out value="${indiaTimeZone}" />
<br/>
<fmt:timeZone value="${indiaTimeZone}">
              <fmt:formatDate value="${myDate}" timeZone="${indiaTimeZone}"
              type="both" />
            </fmt:timeZone>
            
            
<br/>
<br/>
            
</body>
</html>