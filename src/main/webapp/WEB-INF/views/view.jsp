<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>View Menu</title>
</head>
<body>
<form id=frmUpdate action="update" method='post'>
<input type=hidden name=seqno value="${mDto.seqno }">
메뉴명: <input type=text name=name value="${mDto.name }"><br>
가격: <input type=number name=price value="${mDto.price }"><br>
<input type=submit value='수정'>&nbsp;<input type=button value='지우기' id=reset>
</form>
</body>
<script src = "https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
$(document)
.on('click','#reset',function(){
	$('input[name=name],input[name=price],input[name=seqno]').val('')
})
.on('click',':submit',function(){
	if($('input[name=seqno]').val()=='') return false
})
</script>
</html>