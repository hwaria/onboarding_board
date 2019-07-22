<%@ page contentType= "text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Welcome</title>
</head> 
<body>
코드 그룹 리스트
<table border="1">
    <tr>
        <td>코드ID</td>
        <td>코드명</td>
        <td>상세설명</td>
    </tr>
<c:forEach var="codeVO" items="${codeList}" varStatus="roop">
    <tr>
        <td>${codeVO.codeId}</td>
        <td>${codeVO.codeName}</td>
        <td>${codeVO.detailDesc}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>