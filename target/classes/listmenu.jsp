<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Menu List</title>
</head>
<style>
td{border:1px solid blue}
</style>
<body>
<table style='border-collapse:collapse'>
<c:forEach var="a" items="${mlist }">
<tr><td>${a.seqno }</td><td>${a.name }</td>
	<td>${a.price }</td></tr>
</c:forEach>
</table>
</body>
</html>