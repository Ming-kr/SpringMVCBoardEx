<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		작성자 : ${data.member.m_nick }<br>
		제목 : ${data.content.c_title }<br>
		내용 : <br>
		${data.content.c_content }<br>
		<br>
		
		첨부파일 : 
		<c:forEach var="fileData" items="${data.fileList }">
			<img width="200" src="${pageContext.request.contextPath}${fileData.f_savedfilename}">
		</c:forEach>
		<br>
		
		<a href="${pageContext.request.contextPath}/board">목록으로</a>
		<c:if test="${sessionUserData != null && sessionUserData.m_idx == data.member.m_idx}">
			<a href="${pageContext.request.contextPath}/deleteContent?c_idx=${data.content.c_idx }">글 삭제</a>
			<a href="${pageContext.request.contextPath}/updateContentForm?c_idx=${data.content.c_idx }">글 수정</a>
		</c:if>
			
	</div>
</body>
</html>








