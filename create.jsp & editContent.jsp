글 생성 페이지

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create</title>
</head>
<body>
<h1>글 쓰기</h1>
<form action="uploadContent" method="post">
	<div><input type=text name="boardTitle" value="${TestVO.boardTitle}" placeholder="제목" ></div>
	<div><input type=text name="nickNm" value="${TestVO.nickNm}" placeholder="작성자"></div>
	<div><textarea name="boardContent"  placeholder="내용">${TestVO.boardContent}</textarea></div>
	
	<button type="submit">글 올리기</button>	
</form>
</body>
</html>



글 수정 페이지

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function(){
	$("#editCancle").click(function(){
		location.href='history.back()'		
		}
	});
}); */ 
</script>
</head>
<body>
<h1>글 수정하기</h1>
<form action="editContent" method="post">
	<input type="hidden" name= "boardSeq" value="${res.boardSeq}">
	<div><input type=text name="boardTitle" value="${TestVO.boardTitle}" placeholder="${res.boardTitle}" ></div>
	<div><input type=text name="nickNm" value="${TestVO.nickNm}" placeholder="${res.nickNm}" ></div>
	<div><input type="text" name="boardContent"  value="${TestVO.boardContent}" placeholder="${res.boardContent}" ></div>
	
	<button type="submit">글 수정하기</button>	
	
</form>
	<button id="editCancle" onclick="history.back()">취소</button>
</body>
</html>

수정 후

$(document).ready(function(){
	var editedRow = ${editedRow};
	if (editedRow > 0){
		alert("글 수정이 정상 처리되었습니다.");
	}else{
		alert("수정 오류");
	}
	location.href="/main5";
}); 
