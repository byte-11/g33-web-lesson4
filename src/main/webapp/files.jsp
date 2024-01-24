<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File uploads</title>
    <style>
        .container{
            width: 100vw;
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/files" method="post" enctype="multipart/form-data">
        <label for="u_file">
            Upload File: <input type="file" id="u_file" name="u_file">
        </label>
        <br>
        <br>
        <button type="submit">Upload</button>
    </form>
</div>

</body>
</html>
