<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>readContent</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
//var delRow = ${numRow};
//console.log(delRow);

$(document).ready(function(){
	$("#del").click(function(){
		var res = confirm("삭제하시겠습니까?");
		
		if (res){
				//location.href="/view/delete"+${res.boardSeq}; 
				var form = document.getElementById("viewForm");
		
				form.action = 'view/delete';
				form.submit();
				alert("삭제되었습니다.");
		} else {
			alert("취소되었습니다.");
		}	
	});
	
	$("#editContent").click(function(){
		console.log("edt btn works");
		location.href="/view/uploadContent?boardSeq=${res.boardSeq}"
		var form = document.getElementById("viewForm");
		
		form.action = '/view/edit';
		form.submit();
	});
	
}); 


</script>

</head>
<body>
<h1>상세보기</h1>
<form id="viewForm" name="viewForm" method="post">
	<table border = 1>
		<tr><th>제목</th><td>${res.boardTitle}</td></tr>
		<tr><th>작성일</th><td>${res.regDt}</td></tr>
		<tr><th>작성자</th><td>${res.nickNm}</td></tr>
		<tr><th>내용</th><td>${res.boardContent}</td></tr>
		
		
		<h3>첨부 파일</h3>
		<c:if test="${res.fileName ne null}">
			<img src="${res.fileName}" width="600" height="400">
		</c:if>

	</table>
<!--  <form role="form" method="post" action="view/edit" >
	<input type="hidden" name= "boardSeq" value="${res.boardSeq}">
	<button type="submit" id="edit">수정</button>
</form> -->

	<a href='#' type ="button" id="editContent" >수정</a>

	<a href='#' type ="button" id="del">삭제</a>
	
	<!-- <button type ="button" id="mvpage" onClick="history.back()">이전 페이지로 이동</button> -->
	<button type ="button" id="mvpage" onClick="location.href='/main5'">이전 페이지로 이동</button>
	<input type="hidden" name= "boardSeq" value="${res.boardSeq}">
</form>

<%@ include file="cmtView.jsp" %>
</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>readContent</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
//var delRow = ${numRow};
//console.log(delRow);

$(document).ready(function(){
	$("#del").click(function(){
		var res = confirm("삭제하시겠습니까?");
		
		if (res){
				//location.href="/view/delete"+${res.boardSeq}; 
				var form = document.getElementById("viewForm");
		
				form.action = 'view/delete';
				form.submit();
				alert("삭제되었습니다.");
		} else {
			alert("취소되었습니다.");
		}	
	});
	
	$("#editContent").click(function(){
		console.log("edt btn works");
		location.href="/view/uploadContent?boardSeq=${res.boardSeq}"
		var form = document.getElementById("viewForm");
		
		form.action = '/view/edit';
		form.submit();
	});
	
}); 


</script>

</head>
<body>
<h1>상세보기</h1>
<form id="viewForm" name="viewForm" method="post">
	<table border = 1>
		<tr><th>제목</th><td>${res.boardTitle}</td></tr>
		<tr><th>작성일</th><td>${res.regDt}</td></tr>
		<tr><th>작성자</th><td>${res.nickNm}</td></tr>
		<tr><th>내용</th><td>${res.boardContent}</td></tr>
		
		
		<h3>첨부 파일</h3>
		<c:if test="${res.fileName ne null}">
			<img src="${res.fileName}" width="600" height="400">
		</c:if>

	</table>
<!--  <form role="form" method="post" action="view/edit" >
	<input type="hidden" name= "boardSeq" value="${res.boardSeq}">
	<button type="submit" id="edit">수정</button>
</form> -->

	<a href='#' type ="button" id="editContent" >수정</a>

	<a href='#' type ="button" id="del">삭제</a>
	
	<!-- <button type ="button" id="mvpage" onClick="history.back()">이전 페이지로 이동</button> -->
	<button type ="button" id="mvpage" onClick="location.href='/main5'">이전 페이지로 이동</button>
	<input type="hidden" name= "boardSeq" value="${res.boardSeq}">
</form>

<%@ include file="cmtView.jsp" %>
</body>
</html>
