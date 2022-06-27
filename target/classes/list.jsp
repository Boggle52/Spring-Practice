<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Employee List</title>
</head>
<style>
td{border:1px solid blue}
</style>
<body>
<table style='border-collapse:collapse'>
<c:forEach var="empDTO" items="${list }">
<tr><td>${empDTO.employee_id }</td><td>${empDTO.emp_name }</td>
	<td>${empDTO.salary }</td><td>${empDTO.manager_id }</td></tr>
</c:forEach>
</table>
</body>
</html>