<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>Insert title here</title></head>
<body>
	<f:view>
		<h:form>
			<h:outputLabel value="Birth Year"></h:outputLabel>
			<h:inputText value="#{Age.dob}"></h:inputText>
			<h:commandButton action="#{Age.calculateAge}" value="Count!">
			</h:commandButton>
		</h:form>
		<h3>Final AGE: </h3>
		<h:outputLabel value="Current Age is: "></h:outputLabel>
		<h:outputLabel value="#{Age.myAge}"></h:outputLabel>

	</f:view>
</body>
</html>