<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
	<style>
		#wrapper{
			margin: 0 auto;
			border : 1px solid black;
			width: 400px;
		}
	</style>
</head>
<body>

<div id='wrapper'>
	<h3>로그인</h3>
	<form action='${pageContext.request.contextPath}/loginFormAction' method='post'>
		ID : <input type='text' name='m_id'><br>
		PW : <input type='text' name='m_pw'><br>
		<input type='submit' value='로그인'> <a href='${pageContext.request.contextPath}/joinMemberForm'>회원가입</a>
	</form>
</div>





</body>
</html>



