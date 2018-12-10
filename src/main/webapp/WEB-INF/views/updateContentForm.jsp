<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<form action="${pageContext.request.contextPath}/updateContentFormAction">
			작성자 : ${data.member.m_nick }<br>
			제목 : <input type="text" name="c_title" value="${data.content.c_title }"><br>
			내용 : <br>
			<textarea rows="10" cols="40" name="c_content">
				${data.content.c_content }
			</textarea><br>
			<br>
			<input type="hidden" name="c_idx" value="${data.content.c_idx }">
			<input type = "submit" value="글 수정">
		
		
		</form>
	</div>
</body>
</html>








