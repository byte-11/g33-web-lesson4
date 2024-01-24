<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Files Download</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/files/download" method="get">
    <label for="file_name">
        Enter file name : <input type="text" id="file_name" name="file_name">
    </label>
    <br>
    <br>
    <button type="submit"> Download </button>
</form>
</body>
</html>
