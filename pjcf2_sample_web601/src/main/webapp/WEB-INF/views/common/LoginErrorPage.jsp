<%@ page contentType= "text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<script>
var defaultLoginUrl  = "http://member.moneta.co.kr/Auth/login.jsp";
var defaultReturnUrl = "http%3A%2F%2Fwww.moneta.co.kr";
alert("�α����� ����Ǿ����ϴ�. �ٽ� �α����ϼž� �˴ϴ�.");
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
