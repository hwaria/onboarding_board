<%@ page contentType= "text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Code Information</title>
</head> 
<body>
${title}
<form name=mainForm action="http://localhost:8080/${actionValue}">
<table border="1">
    <tr>
        <td>코드ID</td>
        <td>코드명</td>
        <td>상세설명</td>
    </tr>
    <tr>
        <td><input type=text name=codeId value="${codeVO.codeId}" size=4 maxlength=4></td>
        <td><input type=text name=codeName value="${codeVO.codeName}" size=20 maxlength=20></td>
        <td><input type=text name=detailDesc value="${codeVO.detailDesc}" size=40 maxlength=200></td>
    </tr>
    <tr>
        <td rowspan=3 align="center"><input type=submit value="${buttonValue}"></td>
    </tr>
</table>
</form>
</body>
</html>