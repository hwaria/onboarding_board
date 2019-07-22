<%@ page contentType= "text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<script>
var defaultLoginUrl  = "http://member.moneta.co.kr/Auth/login.jsp";
var defaultReturnUrl = "http%3A%2F%2Fwww.moneta.co.kr";
alert("로그인이 만료되었습니다. 다시 로그인하셔야 됩니다.");
<c:choose>
  <c:when test="${empty exception.returnURL}">
      top.location.href = defaultLoginUrl+"?returnURL="+ defaultReturnUrl;
  </c:when>
  <c:otherwise>
  top.location.href = defaultLoginUrl+"?returnURL=${exception.returnURL}";
  </c:otherwise>
</c:choose>
</script>
</body>
</html>
