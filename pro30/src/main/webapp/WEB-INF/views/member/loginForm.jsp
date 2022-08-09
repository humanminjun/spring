<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
	
	<form name="frmLogin" method="get" action="${contextPath }/member/login.do">
	
	<h1>로그인</h1>
	아이디:<input type="text" name="아이디" value="${id}"><br>
	비밀번호:<input type="password" name="비밀번호" value="${pwd}"><br>
	<!-- <button type="submit" >확인</button> -->
	<input type="submit" value="로그인하기">
	
	</form>
	
</body>
</html>