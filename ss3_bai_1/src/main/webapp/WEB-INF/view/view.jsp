<%--
  Created by IntelliJ IDEA.
  User: VAN TAM
  Date: 9/17/2025
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Current Settings</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f4f6f9;
      margin: 0;
      padding: 0;
    }
    .container {
      width: 600px;
      margin: 50px auto;
      background: #ffffff;
      border-radius: 12px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
      padding: 30px;
    }
    h1 {
      text-align: center;
      color: #333333;
      margin-bottom: 20px;
    }
    ul {
      list-style: none;
      padding: 0;
    }
    ul li {
      background: #f9fafc;
      margin: 8px 0;
      padding: 12px 18px;
      border-radius: 8px;
      border-left: 4px solid #3f8efc;
      font-size: 16px;
      color: #444;
    }
    a {
      display: inline-block;
      margin-top: 20px;
      padding: 10px 18px;
      background: #3f8efc;
      color: white;
      text-decoration: none;
      border-radius: 6px;
      transition: background 0.3s;
    }
    a:hover {
      background: #336ed8;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Current Email Settings</h1>
  <ul>
    <li><strong>Language:</strong> ${settings.language}</li>
    <li><strong>Page Size:</strong> ${settings.pageSize}</li>
    <li><strong>Spam Filter:</strong> ${settings.filter ? 'Enabled' : 'Disabled'}</li>
    <li><strong>Signature:</strong> ${settings.signature}</li>
  </ul>
  <a href="${pageContext.request.contextPath}/settings">⬅ Back to Settings</a>
</div>
</body>
</html>
