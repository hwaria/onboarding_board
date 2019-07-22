<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writingForm</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
/*글 올리기 버튼 클릭시 실행  */
$(document).ready(function(){
	
	$(".submitBtn").click(function(){
		
		/* var whichMode = document.getElementsByClassName("writingMode").value; */
		//글양식이 제출되면 쓰기모드에 따라 적절한 컨트롤러로 보내줌  
			var whichMode= "${mode}";
			console.log("모드" + whichMode); 
		if (whichMode == "create") { //글 생성하기
			var form = document.getElementById("createForm");			
			form.action= '/upload';
			form.submit(); 
		} else { // 글 수정하기
			
			var form = document.getElementById("editForm");	
			console.log("view 수정모드");
			form.action= '/edit'; 
			form.submit(); 
		}
	});

});
</script>

</head>
<body>
<h2>글쓰기</h2>
<!--글양식을 보여주는 컨트롤러에서 보낸 모드를 주입  -->
<c:if test="${mode eq 'create'}">
	<form id="createForm" method="post" enctype="multipart/form-data">
		<input type="hidden" class="writingMode" name="mode" value="${mode}">
		<div><input type="text" name="boardTitle" placeholder="제목"/></div>
		<div><input type="text" name="nickNm" placeholder="작성자"/></div>
		<div><textarea name="boardContent" placeholder="내용" style="white-space:pre;"></textarea></div>
		<br>
		<!-- 파일 업로드  -->
		<input type="file" name="fileUpload" multiple/>
		<div><button type="button" class="submitBtn">확인</button></div>
		<div><a href="/main6" type="button">취소</a></div>
	</form>
</c:if>
<!--수정 모드일 경우 수정할 내용이 포함된 글 작성 양식 보여주기  -->
<c:if test="${mode eq 'edit'}">
	<form id="editForm" method="post" enctype="multipart/form-data">
		<input type="hidden" class="writingMode" name="mode" value="${mode}">
		<input type="hidden" name="boardSeq" value="${content.boardSeq}">
		<div><input type="text" name="boardTitle" placeholder="제목" value="${content.boardTitle}"></div>
		<div><input type="text" name="nickNm" placeholder="작성자" value="${content.nickNm}"></div>
		<div><textarea name="boardContent" placeholder="내용" style="white-space:pre;">${content.boardContent}</textarea></div>
		<br>
		<!-- 파일 업로드  -->
		<input type="file" id="fileName" name="fileName" />
		<div><button type="button" class="submitBtn">확인</button></div>
		<div><a href="/main6" type="button">취소</a></div>
	</form>
</c:if>
</body>
</html>