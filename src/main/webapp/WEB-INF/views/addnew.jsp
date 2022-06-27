<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Menu �߰�</title>
</head>
<style>
td{border:1px solid blue}
</style>
<body>
<form id=frmAddNew method=POST action="addMenu">
<input type=text name=mname><br>
<input type=number name=price><br>
<input type=submit value='�߰�'>&nbsp;<input type=reset value='����'>
</form>
<table style='border-collapse:collapse'>
<tr><th>��ȣ</th><th>�̸�</th><th>����</th></tr>
<c:forEach var="menu" items="${mlist }">
<tr>
	<td>
<%-- 	<a href='delete?seqno=${menu.seqno}'>${menu.seqno}</a> --%>
		<a href='delete/${menu.seqno }'>${menu.seqno}</a>
	</td>
	<td>${menu.name }</td>
	<td>${menu.price }</td>
</tr>
</c:forEach>
</table>
</body>
<script src = "https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
$(document)
.on('click','a',function(){
	if(!confirm('������ �����Ͻðڽ��ϱ�?')) return false;
	return true;
})
</script>
</html>