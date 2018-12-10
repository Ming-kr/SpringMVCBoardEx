<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
	<script>
		function confirmID(){
			//전달 값 세팅...
			var valueID = document.getElementById("id").value;
			
			//AJAX...
			var xmlhttp = new XMLHttpRequest();

			xmlhttp.onreadystatechange = function(){
				//콜백 함수...
	            if(xmlhttp.readyState == 4 &&
	            		xmlhttp.status == 200){
	            	//정상 응답일때 처리...
	            	
					var confirmData = 
						JSON.parse(xmlhttp.responseText);
	            	
	            	if(confirmData.existID == true){
	            		alert("이미 존재하는 아이디 입니다.");
	            	}else{
	            		alert("사용 가능한 아이디 입니다.");
	            	}
	            }
			};
			
			xmlhttp.open("POST" , "${pageContext.request.contextPath}/confirmID" , true);
			xmlhttp.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");			
			xmlhttp.send("m_id=" + valueID);
			
			
		}
	</script>


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
		<h3>회원 가입</h3>
		<form action="${pageContext.request.contextPath}/joinMemberFormAction" method='post'>
			ID : <input id="id" type ='text' name='m_id'>
			<button type="button" onclick="confirmID()">중복 확인</button><br>
			PW : <input type='text' name='m_pw'><br>
			NICK : <input type='text' name='m_nick'><br>
			PHONE : <input type='text' name='m_phone'><br>
			<input type='submit' value='회원 가입'>		
		</form>	
	</div>
</body>
</html>







