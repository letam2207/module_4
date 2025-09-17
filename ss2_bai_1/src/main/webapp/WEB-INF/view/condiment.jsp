<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Sandwich Condiments</title>
</head>
<body>
<fieldset>
  <legend>CONDIMENTS</legend>

  <form action="${pageContext.request.contextPath}/add" method="post">
    <input type="checkbox" value="lettuce" name="condiments"> <span>Lettuce</span>
    <input type="checkbox" value="tomato" name="condiments"> <span>Tomato</span>
    <input type="checkbox" value="mustard" name="condiments"> <span>Mustard</span>
    <input type="checkbox" value="sprouts" name="condiments"> <span>Sprouts</span><br>
    <input type="submit" value="Save">
  </form>
</fieldset>

<c:if test="${not empty condiments}">
  <p>Chosen condiments:
    <c:forEach items="${condiments}" var="item">
      ${item}&nbsp;
    </c:forEach>
  </p>
</c:if>
</body>
</html>
