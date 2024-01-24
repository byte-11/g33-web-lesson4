<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form action="#">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" required>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
        <button type="submit">Login</button>
        <p>Don't have an account? <a href="#">Sign up</a></p>
        <p><a href="#">Forgot password?</a></p>
        <p><a href="${pageContext.request.contextPath}/files">Files Page</a></p>
    </form>
</div>
</body>
</html>