<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#goAjax").click(function(){
		var obj = new Object();
		obj.id = "myId123";
		obj.name="자룡";
		obj.age =32;
		
		var jsonData = JSON.stringify(obj); //json형태로 만들어줌 
		
		//{"id":"myId123", "name":"변자룡", "grade": 3}
		
		$.ajax({
			type : "POST",
			url : "/testAjax", //requestMapping 값
			dataType : "json",    //컨트롤러에서 받을 데이터의 형식
			contentType : "application/json; charset=UTF-8", //컨트롤러에서 requestBody로 받을거면 이렇게 명시
			data : jsonData,
			success : function(result) {
				  alert("멥에 들은 갑이 왔는지>"+$("#h2Val").text());
				  $("#html1").html(result.res);
				  if(result.res != "ok"){
					  
				  }else {
					  
				  }
				  
			},
			error:function(xhr, status, err){
				
			}
		});
		
	});
	$("#addPageBTN").click(function(){
		/* var data = {"a":"paxnet", "b":"IT development"}; //서버에 보낼 데이터 */
		
		$.ajax({
			url: "/showForm",  
			dataType:"html", // 서버에서 반환되는 데이터 형식
			type: "post", //기본값은 get
			/* data: JSON.stringify(data), // json문자열로 변환 */
			data:JSON.stringify({
				a: "paxnet",
				b: "IT development"
			}),
			
			contentType : "application/json;charset=UTF-8", /* 서버에 데이터를 보낼 때 사용 */
			success : function(result) {
				alert("form가지고옴");
				$("#ajaxForm").html(result);
			}
		})
	});
	
	$("#goAjaxjsonp").click(function(){
		/* var data = {"a":"paxnet", "b":"IT development"}; //서버에 보낼 데이터 */
		
		$.ajax({
			url: "http://localhost:9090/jsonpTest",  
			dataType:"jsonp", // 서버에서 반환되는 데이터 형식
			type: "post", //기본값은 get
			/* data: JSON.stringify(data), // json문자열로 변환 */
			/* data:JSON.stringify({
				a: "paxnet",
				b: "IT development"
			}),*/
			contentType : "application/json;charset=UTF-8", /* 서버에 데이터를 보낼 때 사용  */
			success : function(result) {
				alert('전송성공');
				/* alert("form가지고옴");
				$("#ajaxForm").html(result); */
			}
		})
	});
	
	
	
	
});

</script>
</head>
<body>
<h2 id="h2Val"><p>아작스 테스트 페이지</p></h2>
<button type="button" id="goAjax">아작스 버튼</button>
<button type="button" id="goAjaxjsonp">jsonp아작스 버튼</button>
<div id="html1"></div>
<div id="ajaxForm">

<button type="button" id="addPageBTN">페이지추가</button> 
</div>
</body>
</html>