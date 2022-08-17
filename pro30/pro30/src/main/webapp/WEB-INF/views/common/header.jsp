<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
</head>
<body>
	<table border=0 width="100%">
		<tr>
			<td><a href="${contextPath}/main.do"> <%-- <img src="${contextPath}/resources/image/duke_swing.gif"  /> --%>
			</a></td>
			<td><a href="${contextPath}/main.do"><h1>
						<font size=30>준 치과</font>
					</h1></a></td>

			<td>
				<!-- <a href="#"><h3>로그인</h3></a> --> <c:choose>
					<c:when test="${isLogOn == true  && member!= null}">
						<c:choose>
							<c:when test="${member.id == 'hong' }">
								 안녕하세요 관리자님 &nbsp; <a href="${contextPath}/member/listMembers.do" class="no-underline">회원목록보기</a>
							</c:when>
							<c:otherwise>
								<h3>환영합니다. ${member.name }님!</h3>
								<a href="${contextPath}/member/mypage.do">마이페이지</a>
							</c:otherwise>
						</c:choose>
						<a href="${contextPath}/member/logout.do">로그아웃</a>
					</c:when>
					<c:otherwise>
						<a href="${contextPath}/member/loginForm.do">로그인</a> &nbsp;
						<a href="${contextPath}/member/memberForm.do">회원가입</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>