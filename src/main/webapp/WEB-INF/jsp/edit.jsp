<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<form action="/customer" method="POST">
<input type="text" value="${name}" name="name">
<input type="hidden" value="${id}" name="id">
<input type="submit">
</form>
<br />
<a href="/customer">Back?</a>