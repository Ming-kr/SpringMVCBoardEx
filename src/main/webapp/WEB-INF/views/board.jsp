<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		#wrapper{
			margin: 0 auto;
			border : 1px solid black;
			width: 800px;
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<c:if test="${sessionUserData != null }">
			${sessionUserData.m_nick }님 환영 합니다. 
			<a href="${pageContext.request.contextPath}/logout">로그 아웃</a>
		</c:if>
		<c:if test="${sessionUserData == null }">
			비회원으로 접근하였습니다. <a href="${pageContext.request.contextPath}/loginForm">로그인</a>
		</c:if>
		<br>
		
		<table>
			<tr>
				<td>글 번호</td>
				<td>글 제목</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>
			<c:forEach var="boardData" items="${boardDataList }">
				<tr>
					<td>${boardData.content.c_idx }</td>
					<td>
						<a href="${pageContext.request.contextPath}/readContentForm?c_idx=${boardData.content.c_idx }">
						${boardData.content.c_title }
						</a>
					</td>
					<td>${boardData.member.m_nick }</td>
					<td>${boardData.content.c_writedate }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<c:if test="${sessionUserData != null }">
			<a href="${pageContext.request.contextPath}/writeContentForm">글 쓰기</a>
		</c:if>
		
	</div>
</body>
</html>









