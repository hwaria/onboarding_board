<%@ page contentType= "text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Welcome</title>
<script>
function goBack(){
	history.go(-1);
}
</script>
</head> 
<body>
<c:choose>
    <c:when test="${rsltYn == 'Y'}">성공</c:when>
    <c:when test="${rsltYn == 'N'}">실패 ${message}</c:when>
</c:choose>
<input type=button value="되돌아가기" onClick="goBack()">
</body>
</html>