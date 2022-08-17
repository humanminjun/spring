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
<title>마이페이지</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	
	<h1  class="text_center">마이페이지</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">아이디</td>
	      <td width="400">${member.id }</td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">비밀번호</td>
	      <td width="400">${member.pwd }</td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이름</td>
	       <td width="400">${member.name }</td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이메일</td>
	       <td width="400">${member.email }</td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <a href="${contextPath}/member/modifyForm.do">수정하기</a>
	    </tr>
	</table>
	
</body>
</html>