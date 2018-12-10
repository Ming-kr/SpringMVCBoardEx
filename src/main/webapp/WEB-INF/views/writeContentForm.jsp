<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
	<style>
		#wrapper{
			margin: 0 auto;
			border : 1px solid black;
			width: 400px;
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<form action="${pageContext.request.contextPath}/writeContentFormAction" 
		method="post"
		enctype="multipart/form-data">
			작성자 : ${sessionUserData.m_nick } <br>
			제목 : <input type ="text" name="c_title"><br>
			내용 : <br>
			<textarea rows="10" cols="40" name="c_content"></textarea><br>
			이미지 파일 : <input type="file" name="files" multiple>
			
			<br>
			<input type="submit" value="글 저장">
		</form>
	</div>
</body>
</html>







