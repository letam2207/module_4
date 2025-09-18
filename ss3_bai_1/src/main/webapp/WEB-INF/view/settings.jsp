<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h1>Settings</h1>
<br/>

<form:form method="post" modelAttribute="settings">
    <table border="0" cellpadding="8">
        <tr>
            <td><strong>Languages</strong></td>
            <td>
                <form:select path="language" items="${languages}"/>
            </td>
        </tr>

        <tr>
            <td><strong>Page Size:</strong></td>
            <td>
                Show
                <form:select path="pageSize" items="${pageSizes}"/>
                emails per page
            </td>
        </tr>

        <tr>
            <td><strong>Spams filter:</strong></td>
            <td>
                <form:checkbox path="filter"/> Enable spams filter
            </td>
        </tr>

        <tr>
            <td><strong>Signature:</strong></td>
            <td>
                <form:textarea path="signature" cols="30" rows="5"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <button type="submit" style="background-color: deepskyblue; color: white">Update</button>
                <button type="reset">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
