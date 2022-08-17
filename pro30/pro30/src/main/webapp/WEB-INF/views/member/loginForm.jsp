<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
<c:choose>
	<c:when test="${result== 'loginFailed' }">
		<script>
			window.onload=function(){
				alert('로그인 정보가 일치하지않습니다.');
			}		
		</script>
	</c:when>
</c:choose>
</head>

<body>
	
	<form name="frmLogin" method="post" action="${contextPath }/member/login.do">
	
	<h1>로그인</h1>
	아이디:<input type="text" name="id" value=""><br>
	비밀번호:<input type="password" name="pwd" value=""><br><!-- name 이랑 쿼리문 맞춰라 -->
	<!-- <button type="submit" >확인</button> -->
	<input type="submit" value="로그인하기">
	
	</form>
	
</body>
</html>