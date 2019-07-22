<%@ page contentType= "text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Code Information</title>
</head> 
<body>
단일 Code 정보
<table border="1">
    <tr>
        <td>코드ID</td>
        <td>코드명</td>
        <td>상세설명</td>
    </tr>
    <tr>
        <td>${codeVO.codeId}</td>
        <td>${codeVO.codeName}</td>
        <td>${codeVO.detailDesc}</td>
    </tr>
</table>
</body>
</html>