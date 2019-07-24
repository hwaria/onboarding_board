<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<!--검색어 입력시 한글깨짐 방지위해 meta 프로퍼티 추가  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="jquery.cookie.js"></script>
<script type="text/javascript">
	/*글 올리기 버튼 클릭시 실행  */
	$(document).ready(function() {
		/* var loginCookie = $.cookie('login'); */

		$("#writeBtn").click(function() {

			var form = document.getElementById("writeMode");

			/*모드는 post 방식으로 날아감*/
			form.action = '/write';
			form.submit();
		});

		$("#searchBtn").click(function() {

			var form = document.getElementById("searchForm");

			form.action = '/main6';
			form.submit();
		});

		$("#logoutBtn").click(function() {

			$.removeCookie("login");
			form.action = '/main6';
			form.submit();
		});

	});
</script>
</head>
<body>
	<h2>Web Board</h2>

	<!--글 생성 버튼  -->
	<form id="writeMode" name="writeMode" method="post">
		<input type="hidden" id="mode" name="mode" value="create">
		<button type="button" id="writeBtn">글 올리기</button>
	</form>

	<!--로그인 쿠키값에 따라서 로그인/로그아웃 버튼 보여주기 -->
	<%-- <c:if test="${loginCookie ne 1 }"> --%>
		<button type="button" onclick="location.href='/login'">로그인</button>
	<%-- </c:if> --%>
<%-- 	<c:if test="${loginCookie eq 1 }">
		<button id="logoutBtn" type="button">로그아웃</button>

	</c:if> --%>

	<!--검색 목록에서 원 게시글 목록으로 돌아가기  -->
	<c:if test="${listType eq 'searches'}">
		<button type="button" onclick="location.href='/main6'">전체
			게시판으로 돌아가기</button>
	</c:if>

	<!--컨트롤러에서 가져온 게시글 목록 테이블에 담아서 화면에 출력  -->
	<table border=1>
		<!--게시판 목록의 컬럼 -->
		<tr>
			<th>No.</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>추천수</th>
		</tr>

		<!--내용을 조건문으로 한 줄씩 뽑아줌 -->
		<c:forEach items="${boardList}" var="TestVO">
			<tr style="text-align: center">
				<!--게시글 내용. 게시글 제목 클릭하면 해당 게시글 상세보기  -->
				<td>${TestVO.boardSeq}</td>
				<td><a href='/view?boardSeq=${TestVO.boardSeq}'>
						${TestVO.boardTitle} </a></td>
				<td>${TestVO.nickNm}</td>
				<td>${TestVO.regDt}</td>
				<td>${TestVO.viewCnt}</td>
				<td>${TestVO.rcmNum}</td>
			</tr>
		</c:forEach>
	</table>

	<!--이전 페이지 블럭으로 이동  -->
	<!--현재 블럭의 첫 번째 페이지가 페이지당 글 수보다 크면 이전 블럭으로 이동하는 버튼 보임  -->
	<c:if test="${paging.startPage > paging.pagesPerBlock}">
		<a href='/main6?page=${paging.startPage - paging.pagesPerBlock}'>&lt;</a>
	</c:if>

	<!--페이지 넘버  -->
	<!--현재 페이지는 두껍게 표시  -->
	<c:forEach var="page" begin="${paging.startPage}"
		end="${paging.endPage}">
		<!--현재 블럭의 페이지  -->
		<c:choose>
			<c:when test="${paging.curPage eq page}">
				<!--현재 페이지가 클릭한 페이지와 같으면  -->
				<!--게시글 목록이 검색 결과인지 여부에 따라 페이지 링크 달라짐  -->
				<c:if test="${listType eq 'original'}">
					<b><a href='/main6?page=${page}'>${page}</a></b>
				</c:if>
				<c:if test="${listType eq 'searches'}">
					<b><a href='/main6?search=${paging.searchWord}&page=${page}'>${page}</a></b>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${listType eq 'original'}">
					<a href='/main6?page=${page}'>${page}</a>
				</c:if>
				<c:if test="${listType eq 'searches'}">
					<a href='/main6?search=${paging.searchWord}&page=${page}'>${page}</a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<!--다음 페이지 블럭으로 이동  -->
	<!--현재 블럭의 첫 번째 페이지와 블럭당 페이지수의 합이 총 페이지 수보다 작거나 같으면 버튼 보임  -->
	<c:if
		test="${paging.startPage + paging.pagesPerBlock <= paging.pagesNum}">
		<a href='/main6?page=${paging.startPage + paging.pagesPerBlock}'>&gt;</a>
	</c:if>

	<!--검색창  -->
	<form id="searchForm" name="searchForm" method="get">
		<input type="text" name="search" placeholder="검색어" />
		<button type="button" id="searchBtn">검색</button>
	</form>

</body>
</html>