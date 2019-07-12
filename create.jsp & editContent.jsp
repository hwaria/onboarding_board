<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create</title>
<script>
function uploadContent(){
	console.log("can i create");
	var form = document.getElementById("writeForm");
	
	
	form.action ='/view/uploadContent';
	form.submit();
}

function editContent(){
	console.log("can i edit");
	var form = document.getElementById("editForm");
	
	
	form.action ='/view/editContent';
	form.submit();
}


/* function uploadFile(){
	console.log("let's upload file")
		
	var fileform = document.getElementById("fileform");
	
	
	fileform.action ='/view/uploadFile';
	fileform.submit();
} */
</script>



</head>
<body>
<h1>글 쓰기</h1>

<c:if test = "${mode eq 'edit'}">
	<form id="editForm" name="writeForm" method="post" enctype="multipart/form-data">
			<input type="hidden" name="regDt" value="${res.regDt}">
			<input type="hidden" name="boardSeq" value="${res.boardSeq}">
			
		<div>
			<input type=text name="boardTitle" id="boardTitle" value="${res.boardTitle}"  placeholder="제목"> 
		</div>
		<div>
			<input type=text name="nickNm" id="nickNm" value="${res.nickNm}" placeholder="작성자" >
		</div>
		<div><textarea name="boardContent" id="boardContent" placeholder="내용">${res.boardContent}</textarea></div>
		<!--글 수정 시 파일 업로드  -->
		<input type="file" id="fileName" name="fileName" />
		
		<button type="button" onclick = 'editContent()'>글 수정</button>	
	</form>
</c:if>
<c:if test = "${mode ne 'edit'}">
	<form id="writeForm" name="writeForm" method="post" enctype="multipart/form-data">
				
			
		<div>	
			<input type=text name="boardTitle" id="boardTitle" placeholder="제목"> 
		</div>
		<div>
			<input type=text name="nickNm" id="nickNm" placeholder="작성자" >
		</div>
		<div><textarea name="boardContent" id="boardContent" placeholder="내용"></textarea></div>
		
		<!--글 생성 시 파일 업로드  -->
		<input type="file" name="fileUpload" multiple/>
		
		<button type="button" onclick = 'uploadContent()'>글 생성</button>	
	</form>
</c:if>


</body>
</html>
