<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>
td{border:1px solid blue}
</style>
<body>
<h1>��� ����</h1>
���: ${member.employee_id }<br>
�̸�: ${member.emp_name }<br>
����: ${member.salary }<br>
�Ŵ��� �̸�: ${member.manager_name }<br>
�Ի� ����: ${member.hire_date }<br>
�̸���: ${member.email }<br>
���� ����: ${cnt }<br> 
<table style='border-collapse:collapse'>
	<c:forEach var="empDTO" items="${list }">
		<tr><td>${empDTO.employee_id }</td><td>${empDTO.emp_name }</td>
			<td>${empDTO.salary }</td><td>${empDTO.manager_id }</td>
		</tr>
	</c:forEach>
</table>
<%-- ���: ${mi.m.employee_id }<br>
�̸�: ${mi.m.emp_name }<br>
����: ${mi.m.salary }<br>
�Ŵ��� �̸�: ${mi.m.manager_name }<br>
�Ի� ����: ${mi.m.hire_date }<br>
�̸���: ${mi.m.email }<br>
���� ����: ${mi.n }<br>
<table style='border-collapse:collapse'>
	<c:forEach var="empDTO" items="${list }">
		<tr><td>${mi.memDTO.employee_id }</td><td>${mi.memDTO.emp_name }</td>
			<td>${mi.memDTO.salary }</td><td>${mi.memDTO.manager_id }</td>
		</tr>
	</c:forEach>
</table> --%>
</body>
</html>