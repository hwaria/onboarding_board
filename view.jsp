<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
			/* location.href="/view/delete"+${res.boardSeq}; */
				alert("삭제되었습니다.");
		} else {
			alert("취소되었습니다.");
		}	
	});
});


</script>

</head>
<body>
<h1>상세보기</h1>
<table border = 1>
<tr><th>제목</th><td>${res.boardTitle}</td></tr>
<tr><th>작성일</th><td>${res.regDt}</td></tr>
<tr><th>작성자</th><td>${res.nickNm}</td></tr>
<tr><th>내용</th><td>${res.boardContent}</td></tr>

</table>
<form role="form" method="post" action="view/edit" >
	<input type="hidden" name= "boardSeq" value="${res.boardSeq}">
	<button type="submit" id="edit">수정</button>
</form>
<form role="form" method="post" action="view/delete" >
	<input type="hidden" name= "boardSeq" value="${res.boardSeq}">
	<button type="submit" id="del">삭제</button>
</form>
	<button id="mvpage" onClick="history.back()">이전 페이지로 이동</button>
</body>
</html>
