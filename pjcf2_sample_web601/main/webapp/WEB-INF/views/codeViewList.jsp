<%@ page contentType= "text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Welcome</title>
</head> 
<body>
�ڵ� �׷� ����Ʈ
<table border="1">
    <tr>
        <td>�ڵ�ID</td>
        <td>�ڵ��</td>
        <td>�󼼼���</td>
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