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
<title>회원가입창</title>
</head>
<body>
<h2>안녕 나 회원가입창 ㅋ</h2>
<form name="frmMember" method="post" action="${contextPath }/member/addMember.do">
	아이디:<input type="text" name="id"><br>
	비밀번호:<input type="password" name="pwd"><br>
	이름:<input type="text" name="name"><br>
	이메일:<input type="text" name="email"><br>
	
	<input type="submit" value="회원가입"> 
</form>
</body>
</html>