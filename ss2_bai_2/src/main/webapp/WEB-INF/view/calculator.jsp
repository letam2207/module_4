<%--
  Created by IntelliJ IDEA.
  User: VAN TAM
  Date: 9/16/2025
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<fieldset>
  <legend>Calculator</legend>
  <form method="post">
    <input type="number" name="num1" value="${num1}">
    <input type="number" name="num2" value="${num2}"><br>


    <input type="submit" name="add" value="Addition(+)"
           formaction="${pageContext.request.contextPath}/add">
    <input type="submit" name="sub" value="Subtraction(-)"
           formaction="${pageContext.request.contextPath}/sub">
    <input type="submit" name="mul" value="Multiplication(x)"
           formaction="${pageContext.request.contextPath}/mul">
    <input type="submit" name="div" value="Division(/)"
           formaction="${pageContext.request.contextPath}/div">
  </form>
</fieldset>

<c:if test="${not empty result}">
  <h2>${result}</h2>
</c:if>
</body>
</html>

