<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<%
  request.setCharacterEncoding("UTF-8");
%>    
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!-- 파일위치를 정의하는 contextPath 외우자 -->

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>메인 페이지</title>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
   <a href="${contextPath}/member/listMembers.do"  class="no-underline">회원목록 보기</a><br>
   <a href="#"  class="no-underline">진료 예약</a><br>
</body>
</html>