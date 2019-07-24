<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>

<script>
/*삭제가 정상 처리되었을 경우 return값인 삭제된 행 수 값을 받아옴  */
var deletedRow = ${deletedRowNum};
if (deletedRow > 0) { // 결과값에 따라 삭제 정상처리 여부 알려준 후 메인 페이지로 이동
	alert("정상 처리 되었습니다."); 	
	location.href='/main6';
} else {
	alert("처리하는 도중에 에러가 발생하였습니다.");
	location.href='/main6';
}
</script>
</head>
<body>

</body>
</html>