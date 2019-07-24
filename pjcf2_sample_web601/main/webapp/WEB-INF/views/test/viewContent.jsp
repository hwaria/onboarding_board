<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Content</title>


<script>
/*삭제 기능  */
function deleteContent(){
	//삭제될 게시글 넘버 가져오기
	var toBeDeleted = "${content.boardSeq}";
	console.log("삭제될 게시글 넘버" + toBeDeleted);
	//게시글 넘버 컨트롤러에 전달
	location.href='/delete?boardSeq=${content.boardSeq}';
}

/*수정기능  */
function editContent(){
	
	var mode = document.getElementById("editBtn").value;
	var toBeEdited = "${content.boardSeq}";
	console.log("수정할 게시글 넘버" + toBeEdited);
	location.href='/write?mode=' + mode + '&boardSeq=' + "${content.boardSeq}";
}

/*파일 삭제 기능  */
function deleteFile(){
	console.log("del works");
	/* var fileAttachedTo = "${content.boardSeq}"; */
	location.href='/deleteFile?boardSeq=${content.boardSeq}'; 
}


</script>

</head>
<body>
<h2>상세 보기</h2>
<table border = 1>
<tr>
	<th>제목</th> 
	<th>작성자</th> 
	<th>글 내용 </th> 
	<th>작성일</th> 
	<th>첨부파일</th>
	<th>추천수</th>
</tr>

<!--게시글 내용  컨트롤러에서 /view로 간 후 해당 게시글 내용 content로 받아옴 -->
<tr>
	<td>${content.boardTitle}</td>
	<td>${content.nickNm}</td>
	<td>${content.boardContent}</td>
	<td>${content.regDt}</td>
	<td>
		<c:if test = "${content.fileName ne null}">
		<!--링크 누르면 다운로드  -->
			<a href="${content.fileName}">파일 보기 </a>
		</c:if> 
		<c:if test = "${content.fileName eq null}">
			첨부파일이 없습니다.
		</c:if>		
	</td>
	<td>${content.rcmNum}</td>
<tr>
</table>


<!--뒤로가기 버튼  -->
<button type="button" onclick="location.href='/main6'">뒤로 가기</button>

<!--수정 버튼  -->
<button type="button" id="editBtn" onclick="editContent()" value="edit">수정하기</button>

<!--삭제 버튼  -->
<button type="button" onclick="deleteContent()">삭제하기</button>

<!--첨부파일 삭제하기  -->
<c:if test = "${content.fileName ne null}">
	<button type="button" id="delFileBtn" onclick="deleteFile()" value="${content.boardSeq}">파일 삭제하기</button>
</c:if> 

<!--추천 수 증가  -->
<a href="/rcm?boardSeq=${content.boardSeq}"><img src ="https://img.icons8.com/cotton/2x/thumb-up.png" width="20px" height="20px">추천</a>

<!--댓글 페이지  -->
<jsp:include page="cmtView.jsp"/>

</body>
</html> 