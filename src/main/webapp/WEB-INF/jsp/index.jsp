<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:forEach var="name" items="${c}">
<form action="/customer/delete" method="GET">
${name.getName()}
<input type="hidden" name="id" value="${name.getId()}" />
<input type="submit" value="delete">
</form>
<form action="/customer/edit" method="POST">
<input type="hidden" name="name" value="${name.getName()}" />
<input type="hidden" name="id" value="${name.getId()}" />
<input type="submit" value="edit" />
</form>
<br />
</c:forEach>
<br />
<h4>Add new person</h4>
<form action="/customer" method="POST">
<input type="text" name="name">
<input type="submit">
</form>