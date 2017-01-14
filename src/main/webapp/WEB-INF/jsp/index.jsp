<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:forEach var="name" items="${c}">
${name.getName()}
<br />
</c:forEach>
<br />
<form action="/customer/add" method="POST">
<input type="text" name="name">
<input type="submit">
</form>