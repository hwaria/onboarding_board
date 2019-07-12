<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comment</title>
<script>
function uploadCmt(){
	console.log("wrting comment");
	var cmtform = document.getElementById("writeCmt");
	
	cmtform.action ='/view/uploadCmt';
	cmtform.submit();	
}


</script>


</head>
<body>
<h1>댓글 쓰기</h1>
<!--댓글 작성 양식  -->
<form id ="writeCmt" name="writeCmt" method="post">
	<div><input type="hidden" name="boardSeq" value="${res.boardSeq}"></div>
	<div><input type="text" name="cmtNickNm" id="cmtNickNm" placeholder="작성자"></div>
	<div><textarea name="cmtContent" id="cmtContent" placeholder="내용"></textarea></div>
	
	<button type="button" onclick="uploadCmt()"> 댓글 달기 </button>
</form>
<h1>댓글 목록</h1>

<!--게시글 상세보기시 댓글이 있을 경우 목록보임  -->
<table>
	<c:forEach var="CmtVO" items="${cmtList}">
		<tr> 
			<td><c:out value="${CmtVO.cmtNickNm}"/></td>
			<td><c:out value="${CmtVO.cmtContent}"/></td>
			<td><c:out value="${CmtVO.cmtRegDt}"/></td>
		</tr>
	</c:forEach>

</table>
<!--댓글 페이지 블럭의 첫 번째 페이지가 페이지당 글 수 보다 클 경우 이전 블럭으로 가는 버튼 보임  -->
<c:if test= "${cmtPage.startPage - cmtPage.rangeSize > 0}">
	<a href='/view?boardSeq=${res.boardSeq}&cmp=${cmtPage.startPage - cmtPage.rangeSize}' 
		style='text-decoration:none'>
			<span> &lt;&lt; </span>
	</a>
</c:if>

<!--현재 댓글 페이지가 첫 번째 페이지가 아닐 경우 이전 페이지로 이동 버튼 보임  -->
<c:if test = "${cmtPage.curPage >1}">
	<a href='/view?boardSeq=${res.boardSeq}&cmp=${cmtPage.prevPage}' 
		style='text-decoration:none'>
			<span>&lt;</span>
	</a>
</c:if>

<!--댓글 목록 페이지 -->


<c:forEach var="cmp" begin="${cmtPage.startPage}" end="${cmtPage.endPage}">
	<!--현재 댓글 페이지에 있을 경우 페이지 넘버 굵게 표시 -->
	<c:choose>
		<c:when test="${cmp eq cmtPage.curPage}">
			<b><a href='/view?boardSeq=${res.boardSeq}&cmp=${cmp}'><span>${cmp}</span></a></b>
		</c:when>
		<c:otherwise>
			<a href='/view?boardSeq=${res.boardSeq}&cmp=${cmp}'><span>${cmp}</span></a>
		</c:otherwise>
	</c:choose>
</c:forEach>

<!--현재 댓글 페이지가 마지막 페이지가 아닐 경우 다음 페이지로 이동 버튼 보임 -->
<c:if test = "${cmtPage.curPage < cmtPage.pageCnt}">
	<a href='/view?boardSeq=${res.boardSeq}&cmp=${cmtPage.nextPage}' style='text-decoration:none'>
		<span> &gt;</span>
	</a>
</c:if>

<!--댓글 페이지 블럭의 현재 블럭이 마지막 블럭이 아니면  이전 블럭으로 가는 버튼 보임  -->
<c:if test= "${cmtPage.curRange ne cmtPage.rangeCnt}">
	<a href='/view?boardSeq=${res.boardSeq}
			&cmp=${cmtPage.startPage + cmtPage.rangeSize}' 
			style='text-decoration:none'><span> &gt;&gt; </span></a>
</c:if>


</body>
</html>
