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
    <c:when test="${rsltYn == 'Y'}">����</c:when>
    <c:when test="${rsltYn == 'N'}">���� ${message}</c:when>
</c:choose>
<input type=button value="�ǵ��ư���" onClick="goBack()">
</body>
</html>