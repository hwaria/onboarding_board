<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cmtView</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<br>
<br>
<br>
<h2>댓글</h2>

<!--댓글이 있을 경우 댓글 목록 보이기  -->
<c:if test="${cmtList.size() ne 0}">
	<table border =1>
		
		<c:forEach var="CmtVO" items="${cmtList}">
			<tr>
				<td>${CmtVO.regmnNickNm }</td>
				<td>${CmtVO.cntn}</td>
				<td>${CmtVO.regDate}</td>
			</tr>
		</c:forEach>
	
	</table>
	
	<!--댓글 페이지 넘버 -->
	<c:forEach var="page" begin="${cmtPaging.startPage}" end="${cmtPaging.endPage}">
		<c:choose> 
			<c:when test ="${cmtPaging.curPage eq page}">
				<b><a href='/view?boardSeq=${cmtPaging.boardSeq}&cmtPage=${page}'>${page}</a></b>
			</c:when>
			<c:otherwise>
				<a href='/view?boardSeq=${cmtPaging.boardSeq}&cmtPage=${page}'>${page}</a>
			</c:otherwise>
		</c:choose>	
	</c:forEach>
		
</c:if>
<br>
<br>
<!--댓글 달기 기능  -->
<form id="cmtForm" name="cmtForm" method="post" action ="/postCmt">
	<input type="hidden" name="boardSeq" value="${content.boardSeq}">
	<input type="text" name="regmnNickNm" placeholder="작성자" />
	<input type="text" name="cntn" placeholder="내용" />
	
	<button type="submit" id="cmtBtn">댓글 달기</button>
</form>

</body>
</html>