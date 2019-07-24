<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	sample °á°ú : ${sample}	  
</h1>
<c:forEach items="${list}" varStatus="status">
${list[status.index]}
</c:forEach>

</body>
</html>