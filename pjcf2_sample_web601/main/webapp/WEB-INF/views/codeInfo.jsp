<%@ page contentType= "text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Code Information</title>
</head> 
<body>
���� Code ����
<table border="1">
    <tr>
        <td>�ڵ�ID</td>
        <td>�ڵ��</td>
        <td>�󼼼���</td>
    </tr>
    <tr>
        <td>${codeVO.codeId}</td>
        <td>${codeVO.codeName}</td>
        <td>${codeVO.detailDesc}</td>
    </tr>
</table>
</body>
</html>