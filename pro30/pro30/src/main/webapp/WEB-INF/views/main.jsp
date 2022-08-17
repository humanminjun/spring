<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- 파일위치를 정의하는 contextPath 외우자 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	
		
	
		<%-- <c:forEach var= "member" items="${member }">
		${member.id }dk
		
		</c:forEach> --%>
	
	
	<%-- <c:choose>
		<c:when test="${member.id = 'hong' } }">		
		</c:when>
		<c:otherwise>
		 	<a href="${contextPath}/member/mypage.do" class="no-underline">마이페이지</a>
		</c:otherwise>
	</c:choose> --%>
	<br>
	<a href="#" class="no-underline">진료 예약</a>
	<br>
	
</body>
</html>



