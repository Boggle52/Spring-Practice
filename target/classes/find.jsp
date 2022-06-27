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
<h1>사원 정보</h1>
사번: ${member.employee_id }<br>
이름: ${member.emp_name }<br>
월급: ${member.salary }<br>
매니저 이름: ${member.manager_name }<br>
입사 일자: ${member.hire_date }<br>
이메일: ${member.email }<br>
팀원 숫자: ${cnt }<br> 
<table style='border-collapse:collapse'>
	<c:forEach var="empDTO" items="${list }">
		<tr><td>${empDTO.employee_id }</td><td>${empDTO.emp_name }</td>
			<td>${empDTO.salary }</td><td>${empDTO.manager_id }</td>
		</tr>
	</c:forEach>
</table>
<%-- 사번: ${mi.m.employee_id }<br>
이름: ${mi.m.emp_name }<br>
월급: ${mi.m.salary }<br>
매니저 이름: ${mi.m.manager_name }<br>
입사 일자: ${mi.m.hire_date }<br>
이메일: ${mi.m.email }<br>
팀원 숫자: ${mi.n }<br>
<table style='border-collapse:collapse'>
	<c:forEach var="empDTO" items="${list }">
		<tr><td>${mi.memDTO.employee_id }</td><td>${mi.memDTO.emp_name }</td>
			<td>${mi.memDTO.salary }</td><td>${mi.memDTO.manager_id }</td>
		</tr>
	</c:forEach>
</table> --%>
</body>
</html>