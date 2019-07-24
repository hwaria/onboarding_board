<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//아이디 중복 여부 확인
	$("#idCheck").click(function(){
		var member = new Object();
		member.id = $("#memberId").val();
		
		var jsonData = JSON.stringify(member);
		
		$.ajax({
			type : "POST",
			url : "/idCheck",
			dataType : "json", //컨트롤러에서 받을 데이터의 형식
			contentType : "application/json; charset=UTF-8", //컨트롤러에서 requestBody로 받을거면 이렇게 명시
			data : jsonData,
			success : function(result) {
				 /*  alert("멥에 들은 갑이 왔는지>"+$("#h2Val").text()); */
				 
				  if(result.res != 1){
					  alert("해당 아이디 사용이 가능합니다.");
					  $("#memberId").html(member.id);
				  }else {
					  alert("중복되는 아이디입니다.");
					  $("#memberId").val("");
				  }
				  
			},
			error:function(xhr, status, err){
				
			}
		});
	})
	//유효성 검사 후 ajax토 쿼리 가입처리		
	$("#regFromBtn").click(function(){
			//유효성 검사위한 정규식
			var reg_pw = /^.*(?=.{8,12})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
			var reg_email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			var reg_name = /^[가-힣]{2,4}$/; //이름 유효성 검사 2~4자 사이, 한글만
			var reg_phone = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;

			var mobileNum1 = $("#phone1").val();
			var mobileNum2 = $("#phone2").val();
			var mobileNum3 = $("#phone3").val();
			var mobileNum = mobileNum1 + mobileNum2 + mobileNum3;
			
			if ($("#memberId").val() =="") {
				alert("아이디를 입력해주세요.")
				$("#memberId").focus();
				return false;
			}

			//비밀번호 형식검사
			if (!reg_pw.test($("#memberPw").val())) {
				alert("비밀번호는 최소 8자 이상으로 대소문자 및 순자를 포함해야 합니다.");
				$("#memberPw").focus();
				return false;
			} 
			//비밀번호 확인 일치 여부
			if ($("#memberPw").val() != $("#checkMemberPw").val()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#checkMemberPw").value = "";
				$("#checkMemberPw").focus();
				return false;
			}
			
			//이름 검사
			if ($("#name").val() =="") {
				alert("이름을 입력해주세요.")
				$("#name").focus();
				return false;
			}
			
			if(!reg_name.test($("#memberName").val())) {
				alert("이름은 2-4자 사이 한글만 가능합니다.")
				return false;	
			}
			
			//닉네임을 따로 지정하지 않을 경우 이름으로 지정
			if($("#nickNm").val() == "") {
				$("#nickNm").val($("#memberName").val());
			}
			
			//이메일 검사
			if(!reg_email.test($("#email").val())) {
				alert("적합하지 않은 이메일 형식입니다.");
				$("#email").focus();
				return false;
			}
			
			//폰번호 검사
			if(!reg_phone.test(mobileNum)) {
				alert("적합하지 않은 번호 형식입니다.");
				$("#phone1").focus();
				return false;
			}
			//ajax로 가입처리
			$.ajax({
				type : "POST",
				url : "/memberRegistration",
				dataType : "json", 
				contentType : "application/x-www-form-urlencoded; chearset=utf-8", //default값
				data : { //객체 형식으로 보낼때는 vo 변수명:값, vo 변수명2:값2..
						memberId: $("#memberId").val(),
						memberPw: $("#memberPw").val(),
						memberName: $("#memberName").val(),
						nickNm: $("#nickNm").val(),
						email: $("#email").val(),
						gender: $(':radio[name="gender"]:checked').val(),
						phone: mobileNum1 + "-" + mobileNum2 + "-" + mobileNum3
				},
				success : function(result) { 
					alert("컨트롤러갔다옴" + result);  
					if(result != 0){
						  alert("회원 가입을 축하합니다.");
						  location.href= '/login';
					}
				},
				error: function(xhr, status, err){
					alert("회원 가입이 정상적으로 처리되지 않았습니다.");
				}
			});
		})
});




</script>
</head>
<body>
<!--회원 가입  -->
<h2>회원 가입 양식</h2>
<form id="joinForm" name="joinForm" method="post">
	<table border="1">
		<tr>회원 기본 정보</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="memberId" id="memberId" maxlength="10"/>
				<button type="button" id="idCheck">중복 확인</button>
			</td>
			
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="memberPw" id="memberPw" maxlength="10"/>*8 - 10자 영문 대소문자와 숫자의 혼합</td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" name="checkMemberPw" id="checkMemberPw" maxlength="10"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" id="memberName" maxlength="5"/></td>
		</tr>
		
		<tr>
			<td>닉네임</td>
			<td><input type="text" name="nickNm" id="nickNm" maxlength="10"/></td>
		</tr>						
		<tr>
			<td>성별</td>
			<td>
				<input class="gender" type="radio" name="gender" value="1"/>남자
				<input class="gender" type="radio" name="gender" value="2"/>여자
			</td>			
		</tr>		
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" id="email" maxlength="25"/></td>		
		</tr>
		<tr>
			<td>핸드폰 번호</td>
			<td>
				<input type="text" name="phone" id="phone1" maxlength="3"/>-
				<input type="text" name="phone" id="phone2" maxlength="4"/>-
				<input type="text" name="phone" id="phone3" maxlength="4"/>			
			</td>		
		</tr>				
	</table>
	<button type="button" id="regFromBtn">회원 가입</button>

</form>
	<button type="submit" onclick="history.back();">취소</button>
</body>
</html>