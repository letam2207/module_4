<%--
  Created by IntelliJ IDEA.
  User: VAN TAM
  Date: 9/16/2025
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
  <table>
    <tr>
      <th>USD</th>
      <th></th>
      <th>VND</th>
    </tr>
    <tr>
      <td><input type="text" name="usd" value="${usd}" min="0"></td>
      <td><p>=></p></td>
      <td><input type="number" name="vnd" value="${vnd}" readonly></td>
    </tr>
  </table>
  <button>Chuyển đổi</button>
</form>
</body>
</html>
