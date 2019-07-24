<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<!-- <script src="/test/jquery.cookie.js"></script> -->
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#loginBtn").click(function(){
		$.ajax({
			type : "POST",
			url : "/logging",
			dataType : "json", 
			contentType : "application/x-www-form-urlencoded; chearset=utf-8",
			data : { //객체 형식으로 보낼때는 vo 변수명:값, vo 변수명2:값2..
					memberId: $("#memberId").val(),
					memberPw: $("#memberPw").val(),				
			},
			success : function(result) { 
				if(result.res != 0){
				  alert("로그인하였습니다.");
				 /*  saveCookie();  */
				  location.href ="/main6";
				} else{
				  alert("ID와 비밀번호를 다시 한번 확인해주세요.");
				}
			},
			error: function(xhr, status, err){
				alert("로그인 실패");
			}
		});

	});
/* 	function saveCookie() {
		$.cookie('login', 1, {path:'/', domain:"http://localhost:8080"});
	} */
	
});
</script>
</head>
<body>
<!--로그인 페이지  -->
<h2>로그인 정보를 입력해주세요</h2>

<form id="loginForm" name="loginForm">
	<table border = "1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="memberId" id="memberId" maxlength="10"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="memberPw" id="memberPw" maxlength="10"/></td>
		</tr>
	
	</table>
	<button type="button" id="loginBtn">확인</button>

</form>

<button type="button" onclick="location.href='/moveToReg'">회원 가입</button>
</body>
</html>